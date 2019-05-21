package com.centit.app.security;

/**
 * 加密、解密中出现的异常类
 * 
 * @author jiangf
 * @version 1.0.0.0
 */
public class CipherException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CipherException(Exception caseE) {
		super(caseE);
	}

	public CipherException(String msg) {
		super(msg);
	}
}
