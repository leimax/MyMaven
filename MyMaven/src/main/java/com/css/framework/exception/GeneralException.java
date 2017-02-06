package com.css.framework.exception;

/**
 * 异常通用类 整合deppon异常类
 * 
 * @author 陈圣圣 date 2017-02-05 17:00
 */
public abstract class GeneralException extends RuntimeException implements
		IException {

	private static final long serialVersionUID = 1L;
	protected String errCode;
	private String nativeMsg;
	private Object[] arguments;

	public GeneralException() {
		super();
	}

	public GeneralException(String msg) {
		super(msg);
	}

	public GeneralException(Throwable cause) {
		super(cause);
	}

	public GeneralException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneralException(Throwable cause, String nativeMsg) {
		super(cause);
		this.nativeMsg = nativeMsg;
	}

	public GeneralException(String msg, String nativeMsg) {
		super(msg);
		this.nativeMsg = nativeMsg;
	}

	public GeneralException(String message, Throwable cause, String nativeMsg) {
		super(message, cause);
		this.nativeMsg = nativeMsg;
	}

	public GeneralException(String errCode, String message, Throwable cause,
			Object... arguments) {
		super(message, cause);
		this.errCode = errCode;
		this.arguments = arguments;
	}

	public GeneralException(String errCode, String message, Throwable cause,
			String nativeMsg, Object... arguments) {
		super(message, cause);
		this.errCode = errCode;
		this.arguments = arguments;
		this.nativeMsg = nativeMsg;
	}

	public String getErrorCode() {
		return errCode;
	}

	public void setErrorArguments(Object... args) {
		this.arguments = args;
	}

	public String getNativeMessage() {
		return this.nativeMsg;
	}

	public Object[] getErrorArguments() {
		return this.arguments;
	}

}
