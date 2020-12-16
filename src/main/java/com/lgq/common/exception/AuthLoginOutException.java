package com.lgq.common.exception;

/**
 * 自定义登录异常
 * @author 刘国强
 */
public class AuthLoginOutException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;

    public AuthLoginOutException(String msg) {
        super(msg);
    }

    public AuthLoginOutException(String msg, Throwable ex) {
        super(msg, ex);
    }
    
}
