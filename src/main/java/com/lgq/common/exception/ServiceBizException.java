package com.lgq.common.exception;

import java.io.Serializable;

/**
 * 自定义业务异常
 * @author 刘国强
 */
public class ServiceBizException extends RuntimeException {
	
	private static final long serialVersionUID = 5948018638602481391L;
	private Serializable exceptionData;

	public ServiceBizException(Exception e) {
		super(e);
	}

	public ServiceBizException(String msg) {
		super(msg);
	}

	public ServiceBizException(String msg, Serializable exceptionData) {
		super(msg);
		this.exceptionData = exceptionData;
	}

	public ServiceBizException(String msg, Exception e) {
		super(msg, e);
	}

	public Serializable getExceptionData() {
		return this.exceptionData;
	}

	public void setExceptionData(Serializable exceptionData) {
		this.exceptionData = exceptionData;
	}
	
}
