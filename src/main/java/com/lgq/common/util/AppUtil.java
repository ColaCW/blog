//package com.lgq.common.util;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.lgq.admin.dao.UserSQL;
//import com.lgq.admin.obj.UserObj;
//
//@Repository
//public class AppUtil {
//
//	public static UserSQL userSQL;
//
//	@Autowired
//	public void setUserSQL(UserSQL userSQL) {
//		AppUtil.userSQL = userSQL;
//	}
//
//	// 根据用户生成JWT
//	public static String createJWT(UserObj userObj) {
//		return JWT.create().withAudience(userObj.getId()).sign(Algorithm.HMAC256(userObj.getPassword()));
//	}
//
//	// 根据请求头JWT获取当前用户
//	public static UserObj getUser(HttpServletRequest request) {
//		String jwt = request.getHeader("jwt");
//		String userId = JWT.decode(jwt).getAudience().get(0);
//		return userSQL.findById(userId).get();
//	}
//}
