package com.css.framework.exception;

/**
 * 异常 author 陈圣圣 date 2017-02-05 17:00
 */
public class AllStorageException extends GeneralException {

	private static final long serialVersionUID = 1L;

	public AllStorageException(String message) {
		super(message);
	}

	public AllStorageException(Throwable e) {
		super(e);
	}

	public AllStorageException(String message, Throwable cause) {
		super(message, cause);
	}

}
