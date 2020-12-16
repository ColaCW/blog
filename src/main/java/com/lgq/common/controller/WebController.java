package com.lgq.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgq.common.authentication.UserLoginToken;
import com.lgq.entity.admin.SystemMenuPO;
import com.lgq.mapper.admin.SystemMenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/web")
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
public class WebController {

	private Logger logger = LoggerFactory.getLogger(WebController.class);

	@Autowired
	private SystemMenuMapper systemMenuMapper;

//
//	// 登录
//	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
//	@PassToken
//	public ResultObj login(@RequestBody Map<String, String> param) throws Exception {
//		ResultObj result = new ResultObj();
//		String phone = param.get("phone");
//		String password = param.get("password");
//		UserObj userObj = userSQL.findByUsernameOrMobile(phone, phone);
//		if (userObj == null) {
//			throw new ServiceBizException("用户不存在");
//		} else {
//			if (!password.equals(userObj.getPassword())) {
//				throw new ServiceBizException("密码错误");
//			} else {
//				userObj.jwt = AppUtil.createJWT(userObj);
//				userObj.setPassword("***");
//				userObj.roleObj = systemRoleSQL.findById(userObj.getRoleId()).get();
//				userObj.accessList = systemAccessSQL.findByRoleId(userObj.getRoleId());
//				log.info(userObj.getRealname() + "登录成功");
//				result.setData(userObj);
//			}
//		}
//		return result;
//	}
//
//	// 退出登录
//	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
//	@UserLoginToken
//	public void logout(@RequestBody Map<String, Object> param) throws Exception {
//	}
//
	// 根据角色获取菜单
	@GetMapping(value = "/getMenusByRole")
	@UserLoginToken
	public List<SystemMenuPO> getMenusByRole() {
		QueryWrapper<SystemMenuPO> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("IS_DELETED", 0);
		return systemMenuMapper.selectList(queryWrapper);
	}
//
//	// 检查图片验证码
//	@RequestMapping(value = "/checkImgCode.do", method = RequestMethod.POST)
//	@PassToken
//	public ResultObj checkImgCode(HttpSession session, @RequestBody Map<String, Object> param) throws Exception {
//		ResultObj result = new ResultObj();
//		String imgCode = param.get("imgCode").toString();
//		String oldImgCode = session.getAttribute("imgcode").toString();
//		if (StringUtil.isEmpty(oldImgCode)) {
//			throw new ServiceBizException("Session中无图片验证码");
//		}
//		if (oldImgCode.equalsIgnoreCase(imgCode)) {
//			return result;
//		} else {
//			throw new ServiceBizException("验证失败");
//		}
//
//	}
//
//	// 发送手机验证码
//	@RequestMapping(value = "/sendMobileCode.do")
//	@PassToken
//	public ResultObj getMobileCode(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ResultObj result = new ResultObj();
//		return result;
//	}
//
//	// 检查手机短信验证码
//	@RequestMapping(value = "/checkMobileCode.do")
//	@PassToken
//	public ResultObj checkMobileCode(HttpSession session, HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		ResultObj result = new ResultObj();
//		return result;
//	}
//
//	// 发送邮件接口
//	@RequestMapping(value = "/sendEmail.do")
//	@PassToken
//	public ResultObj sendEmail(HttpSession session, HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		ResultObj result = new ResultObj();
//		return result;
//	}
//
//	// 获取七牛云token
//	@RequestMapping(value = "/getQiniuUpToken.do")
//	@PassToken
//	public ResultObj getQiniuUpToken(HttpSession session, HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		ResultObj result = new ResultObj();
//		QiniuUploadUtil.getQiniuUpToken(result);
//		return result;
//	}
//
//	// 更新上传文件到本地数据库
//	// @RequestMapping(value = "/uploadFile.do")
//	// public ResultObj uploadFile(HttpSession session, HttpServletRequest request,
//	// HttpServletResponse response) throws Exception {
//	// ResultObj result = new ResultObj();
//	// Map<String, String> param = AppUtil.getBodyParams(request);
//	// String token = param.get("token");
//	// String fileSrc = param.get("fileSrc");
//	// UserObj user = AppUtil.getUser();
//	// if(user != null) {
//	// UploadObj uploadObj = new UploadObj();
//	// uploadObj.setId(StringUtil.getId());
//	// uploadObj.setUploadPath(fileSrc);
//	// uploadObj.setFileExt(fileSrc.substring(fileSrc.lastIndexOf("."),fileSrc.length()));
//	// uploadObj.setCreateAt(StringUtil.getFormatDate(new Date(), "yyyy-MM-dd
//	// HH:mm:ss"));
//	// uploadObj.setCreateBy(user.getId());
//	// uploadObj.setDeleteBy("0");
//	// uploadSQL.save(uploadObj);
//	// result.setStatus(true);
//	// result.setData(uploadObj.getId());
//	// }
//	// return result;
//	// }
//
}
