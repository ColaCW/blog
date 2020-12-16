package com.blog;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.lgq.common.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成工具类
 *
 * @author: liugq
 * @time: 2020/7/4
 */
public class CodeGenerator {
    public static final String OUT_PUT_DIR = "/Users/liuguoqiang/Documents/work/lgqWork/"; // 输出路径
    public static final String AUTHOR = "liugq"; // 作者
    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver"; // 数据源
    public static final String URL = "jdbc:mysql://www.lgqoxb.top:3306/blog?characterEncoding=utf-8&useSSL=false"; // 数据库地址
    public static final String USERNAME = "lgq"; // 用户名
    public static final String PASSWORD = "1234"; // 密码
    public static final String TABLE_PREFIX = "t_"; // 去除表名前缀（逗号分隔）
    public static final String TABLES = "t_blog_detail"; // 要生成的表


    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 设置参数
        setAutoGenerator(mpg);
        //执行生成
        mpg.execute();
    }

    private static void setAutoGenerator(AutoGenerator mpg) {
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(OUT_PUT_DIR); // 输出路径
        gc.setFileOverride(true); // 是否覆盖文件
        gc.setActiveRecord(true); // ActiveRecord特性
        gc.setEnableCache(false); // XML二级缓存
        gc.setBaseResultMap(true); // XML ResultMap
        gc.setBaseColumnList(false); // XML columList
        gc.setAuthor(AUTHOR); // 作者

        //自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setEntityName("%sPO");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(DRIVER_CLASS_NAME);
        dsc.setUrl(URL);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{TABLE_PREFIX});//此处可以修改您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel); //表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //列名生成策略
        strategy.setInclude(new String[]{TABLES});//需要生成的表
        strategy.setVersionFieldName("VERSION"); // 版本号(乐观锁)字段名称
        strategy.setLogicDeleteFieldName("IS_DELETED"); // 逻辑删除字段
        strategy.setSuperMapperClass(null);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);

        mpg.setStrategy(strategy);

        // 生成包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.lgq");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("mybatis.mapper");
        mpg.setPackageInfo(pc);

        // 读取自定义文件模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("templates/controller.java");
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        templateConfig.setMapper("templates/mapper.java");
        templateConfig.setXml("templates/mapper.xml");
        mpg.setTemplate(templateConfig);


        // 自定义属性注入
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("packageName", "com.lgq.dto");
                map.put("tableName", this.getConfig().getTableInfoList().get(0).getEntityName().replace("PO", ""));
                map.put("comment", this.getConfig().getTableInfoList().get(0).getComment());
                map.put("fields",   this.getConfig().getTableInfoList().get(0).getFields());
                map.put("author", "liugq");
                map.put("date", LocalDateTime.now());
                this.setMap(map);
            }
        };


        List<FileOutConfig> focList = new ArrayList<>();
        // 根据模版生成自定义dto文件
        focList.add(new FileOutConfig("templates/dto.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意名称会跟着发生变化！！
                return OUT_PUT_DIR + "/com/lgq/dto/" + tableInfo.getEntityName().replace("PO", "") + "DTO" + StringPool.DOT_JAVA;
            }
        });
        // 根据模版生成自定义index.vue文件
        focList.add(new FileOutConfig("templates/index.vue.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意名称会跟着发生变化！！
                return OUT_PUT_DIR + "/blogManagement/" + StringUtils.lowerFirstCase(tableInfo.getEntityName().replace("PO", "")) + "/index.vue";
            }
        });
        // 根据模版生成自定义index.js文件
        focList.add(new FileOutConfig("templates/index.js.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意名称会跟着发生变化！！
                return OUT_PUT_DIR + "/api/blogManagement/" + StringUtils.lowerFirstCase(tableInfo.getEntityName().replace("PO", "")) + "/index.js";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

    }
}
