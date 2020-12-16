//package com.lgq.common.authentication;
//
//import java.lang.reflect.Method;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.lgq.admin.dao.UserSQL;
//import com.lgq.admin.obj.UserObj;
//import com.lgq.common.exception.AuthLoginOutException;
//
////身份认证拦截器
//@Component
//public class AuthenticationInterceptor implements HandlerInterceptor {
//
//	public static UserSQL userSQL;
//
//	@Autowired
//	public void setUserSQL(UserSQL userSQL) {
//		AuthenticationInterceptor.userSQL = userSQL;
//	}
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
//
//		String jwt = request.getHeader("jwt");// 从 http 请求头中取出 token
//
//		// 如果不是映射到方法直接通过
//		if (!(object instanceof HandlerMethod)) {
//			return true;
//		}
//		HandlerMethod handlerMethod = (HandlerMethod) object;
//		Method method = handlerMethod.getMethod();
//		// 有passtoken注解,跳过认证
//		if (method.isAnnotationPresent(PassToken.class)) {
//			PassToken passToken = method.getAnnotation(PassToken.class);
//			if (passToken.required()) {
//				return true;
//			}
//		}
//		// 有UserLoginToken注解,检查用户是否登录
//		if (method.isAnnotationPresent(UserLoginToken.class)) {
//			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
//			if (userLoginToken.required()) {
//
//				//设置请求体，防止返回false时导致的跨域问题
//				response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//				response.setHeader("Access-Control-Allow-Credentials", "true");
//				response.setHeader("Access-Control-Max-Age", "3600");
//				response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACES");
//				response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
//
//				// 判断jwt
//				if (jwt == null || "undefined".equals(jwt)) {
//					 throw new AuthLoginOutException("用户未登录");
//				}
//
//				// 获取 jwt 中的 user id
//				String userId;
//				try {
//					userId = JWT.decode(jwt).getAudience().get(0);
//				} catch (Exception e) {
//					throw new AuthLoginOutException("JWT已失效");
//				}
//				UserObj userObj = userSQL.findById(userId).get();
//				if (userObj == null) {
//					throw new AuthLoginOutException("用户不存在");
//				}
//
//				// 验证 jwt
//				JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userObj.getPassword())).build();
//				try {
//					jwtVerifier.verify(jwt);
//				} catch (Exception e) {
//					throw new AuthLoginOutException("JWT已失效");
//				}
//
//				return true;
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
//			ModelAndView modelAndView) throws Exception {
//
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)
//			throws Exception {
//
//	}
//}
