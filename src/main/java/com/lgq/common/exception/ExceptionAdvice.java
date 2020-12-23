package com.lgq.common.exception;

import com.lgq.common.baseObj.ResultObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一处理异常
 * @author 刘国强
 */
@RestControllerAdvice
public class ExceptionAdvice {

	/**
	 * Logger日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

	/**
	 * 默认异常
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity exception(Exception error) {
		return new ResponseEntity<>(new ResultObj(500, "系统出错,请联系管理员"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * 自定义业务异常
	 */
	@ExceptionHandler(ServiceBizException.class)
	@ResponseBody
	public ResponseEntity runtimeException(ServiceBizException error) {
		return new ResponseEntity<>(new ResultObj(500, error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 自定义登录异常
	 */
	@ExceptionHandler(AuthLoginOutException.class)
	@ResponseBody
	public ResponseEntity authLoginOutException(AuthLoginOutException error) {
		return new ResponseEntity<>(new ResultObj(401, error.getMessage()), HttpStatus.UNAUTHORIZED);
	}

}
