package com.lgq.common.util;

import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Java 类型转换
 *
 * @author lwh
 * @date 2019年8月20日
 */
public class MapUtil {
    private static final char UNDERLINE='_';

    private static String camelToUnderline(String origin){
        return stringProcess(
                origin, (prev, c) -> {
                    if (Character.isLowerCase(prev) && Character.isUpperCase(c)) {
                        return "" + UNDERLINE + Character.toLowerCase(c);
                    }
                    return ""+c;
                }
        );
    }

    private static String underlineToCamel(String origin) {
        if(origin.indexOf(UNDERLINE)!=-1||(origin.matches("^[A-Z]*$")||origin.matches("^[a-z]*$"))){
            origin=origin.toLowerCase();
        }else{
            return origin;
        }
     //   origin=origin.indexOf(UNDERLINE)!=-1?origin.toLowerCase():origin;
        return stringProcess(
                origin, (prev, c) -> {
                    if (prev == '_' && Character.isLowerCase(c)) {
                        return "" + Character.toUpperCase(c);
                    }
                    if (c == '_') {
                        return "";
                    }
                    return ""+c;
                }
        );
    }

    private static String stringProcess(String origin, BiFunction<Character, Character, String> convertFunc) {
        if (origin==null||"".equals(origin.trim())){
            return "";
        }
        String newOrigin = "0" + origin;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < newOrigin.length()-1; i++) {
            char prev = newOrigin.charAt(i);
            char c=newOrigin.charAt(i+1);
            sb.append(convertFunc.apply(prev,c));
        }
        return sb.toString();
    }

    private static void tranferKeyToUnderline(Map<String,Object> map,
                                             Map<String,Object> resultMap,
                                             Set<String> ignoreKeys) {
        Set<Map.Entry<String,Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry: entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (ignoreKeys.contains(key)) {
                resultMap.put(key, value);
                continue;
            }
            String newkey = underlineToCamel(key);
            if ( (value instanceof List) ) {
                List newList = buildValueList(
                        (List) value, ignoreKeys,
                        (m, keys) -> {
                            Map subResultMap = new HashMap();
                            tranferKeyToUnderline((Map) m, subResultMap, ignoreKeys);
                            return subResultMap;
                        });
                resultMap.put(newkey, newList);
            }
            else if (value instanceof Map) {
                Map<String, Object> subResultMap = new HashMap<String,Object>();
                tranferKeyToUnderline((Map)value, subResultMap, ignoreKeys);
                resultMap.put(newkey, subResultMap);
            }
            else {
                resultMap.put(newkey, value);
            }
        }
    }

    private static Map<String,Object> tranferKeyToUnderline2(Map<String,Object> map,
                                                            Set<String> ignoreKeys) {
        Set<Map.Entry<String,Object>> entries = map.entrySet();
        Map<String,Object> resultMap = new HashMap<String,Object>();
        for (Map.Entry<String, Object> entry: entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (ignoreKeys.contains(key)) {
                resultMap.put(key, value);
                continue;
            }
            String newkey = underlineToCamel(key);
            if ( (value instanceof List) ) {
                List valList = buildValueList((List)value, ignoreKeys,
                        (m, keys) -> tranferKeyToUnderline2(m, keys));
                resultMap.put(newkey, valList);
            }
            else if (value instanceof Map) {
                Map<String, Object> subResultMap =  tranferKeyToUnderline2((Map)value, ignoreKeys);
                resultMap.put(newkey, subResultMap);
            }
            else {
                resultMap.put(newkey, value);
            }
        }
        return resultMap;
    }

    private static List buildValueList(List valList, Set<String> ignoreKeys,
                                      BiFunction<Map, Set, Map> transferFunc) {
        if (valList == null || valList.size() == 0) {
            return valList;
        }
        Object first = valList.get(0);
        if (!(first instanceof List) && !(first instanceof Map)) {
            return valList;
        }
        List newList = new ArrayList();
        for (Object val: valList) {
            Map<String,Object> subResultMap = transferFunc.apply((Map) val, ignoreKeys);
            newList.add(subResultMap);
        }
        return newList;
    }

    private static Map<String,Object> generalMapProcess(Map<String,Object> map,
                                                       Function<String, String> keyFunc,
                                                       Set<String> ignoreKeys) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        map.forEach(
                (key, value) -> {
                    if (ignoreKeys.contains(key)) {
                        resultMap.put(key, value);
                    }
                    else {
                        String newkey = keyFunc.apply(key);
                        if ( (value instanceof List) ) {
                            resultMap.put(keyFunc.apply(key),
                                    buildValueList((List) value, ignoreKeys,
                                            (m, keys) -> generalMapProcess(m, keyFunc, ignoreKeys)));
                        }
                        else if (value instanceof Map) {
                            Map<String, Object> subResultMap =  generalMapProcess((Map) value, keyFunc, ignoreKeys);
                            resultMap.put(newkey, subResultMap);
                        }
                        else {
                            resultMap.put(keyFunc.apply(key), value);
                        }
                    }
                }
        );
        return resultMap;
    }


    /**
     * 利用反射将map集合封装成bean对象
     *
     * @param params
     * @param clazz
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {
        Object obj = clazz.newInstance();
        if (map != null && !map.isEmpty() && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey(); 	// 属性名
                Object value = entry.getValue();		// 属性值
                String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                Field field = getClassField(clazz, propertyName);	//获取和map的key匹配的属性名称
                if (field == null){
                    continue;
                }
                Class<?> fieldTypeClass = field.getType();
                if(!StringUtils.isNullOrEmpty(value)) {
                	value = convertValType(value, fieldTypeClass);
                }
                try {
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) obj;
    }

    /**
     * 根据给定对象类匹配对象中的特定字段
     * @param clazz
     * @param fieldName
     * @return
     */
    private static Field getClassField(Class<?> clazz, String fieldName) {
        if (clazz.isAssignableFrom(Object.class)) {
            return null;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        Class<?> superClass = clazz.getSuperclass();	//如果该类还有父类，将父类对象中的字段也取出
        if (superClass != null) {						//递归获取
            return getClassField(superClass, fieldName);
        }
        return null;
    }

    /**
     * 将map的value值转为实体类中字段类型匹配的方法
     * @param value
     * @param fieldTypeClass
     * @return
     */
    private static Object convertValType(Object value, Class<?> fieldTypeClass) {
        Object retVal = null;

        if (fieldTypeClass.isAssignableFrom(Long.class)
                || fieldTypeClass.isAssignableFrom(long.class)) {
            retVal = Long.parseLong(value.toString());
        } else if (fieldTypeClass.isAssignableFrom(Integer.class)
                || fieldTypeClass.isAssignableFrom(int.class)) {
            retVal = Integer.parseInt(value.toString());
        } else if (fieldTypeClass.isAssignableFrom(Float.class)
                || fieldTypeClass.isAssignableFrom(float.class)) {
            retVal = Float.parseFloat(value.toString());
        } else if (fieldTypeClass.isAssignableFrom(Double.class)
                || fieldTypeClass.isAssignableFrom(float.class)) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }







    /**
     * 将list<map>转list<T><br>
     *
     *
     * @param List<Map> 要转的list<map>
     * @return
     */
    public static List<Map> listMapUnderlineToCamel(List<Map> result){
        List newList= new ArrayList<>();
        for (Map map: result) {
            newList.add(tranferKeyToUnderline2(map,new HashSet<>()));
        }
        return newList;
    }

    /**
     * 将list<map>转list<T><br>
     *
     *
     * @param List<Map> 要转的list<map>
     *    @param    Set<String> 不需要转的字段
     * @return
     */
    public static List<Map> listMapUnderlineToCamel(List<Map> result,Set<String> unChange){
        List newList= new ArrayList<>();
        for (Map map: result) {
            newList.add(tranferKeyToUnderline2(map,unChange));
        }
        return newList;
    }

    /**
     * 将map转对象
     *
     *
     * @param Map 要转的map
     *    @param    Set<String> 不需要转的字段
     * @return
     */
    public static Map mapUnderlineToCamel(Map<String,Object> map){
     return tranferKeyToUnderline2(map,new HashSet<>());
    }

    /**
     * 将map转对象
     *
     *
     * @param Map 要转的map
     *    @param    Set<String> 不需要转的字段
     * @return
     */
    public static Map mapUnderlineToCamel(Map<String,Object> map,Set<String> unChange){
        return tranferKeyToUnderline2(map,unChange);
    }
    /**
     * 利用反射将map集合封装成bean对象
     *
     * @param params
     * @param clazz
     * @return
     */
    public static <T> T mapToBeanwithCamel(Map<String, Object> oldMap, Class<?> clazz) throws Exception {
        Map<String, Object> map=tranferKeyToUnderline2(oldMap,new HashSet<>());
        Object obj = clazz.newInstance();
        if (map != null && !map.isEmpty() && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey(); 	// 属性名
                Object value = entry.getValue();		// 属性值
                String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                Field field = getClassField(clazz, propertyName);	//获取和map的key匹配的属性名称
                if (field == null){
                    continue;
                }
                Class<?> fieldTypeClass = field.getType();
                value = convertValType(value, fieldTypeClass);
                try {
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) obj;
    }
    public static <T> List<T> listMapToBeanwithCamel(List<Map<String, Object>> oldList, Class<?> clazz) throws Exception {
        List<T> resultList=new ArrayList<>();
        for (Map map:oldList) {
            resultList.add((T)mapToBeanwithCamel(map,clazz));
        }
        return resultList;
    }
    /**
     * 将对象装换为map
     *
     * @param bean 对象
     * @Author Lius
     * @Date 2020/7/23
     * @Return java.util.Map<java.lang.String, java.lang.Object>
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }
}
