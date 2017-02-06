package com.css.framework.exception;

/**
 * Òì³£»ùÀà ÕûºÏdepponÒì³£Àà
 * 
 * @author ³ÂÊ¥Ê¥ date 2017-02-05 17:00
 */
public interface IException {

	/**
	 * @author:³ÂÊ¥Ê¥
	 * @return String .
	 */
	String getErrorCode();

	/**
	 * @author:³ÂÊ¥Ê¥
	 * @return String .
	 */
	String getNativeMessage();

	/**
	 * @author:³ÂÊ¥Ê¥
	 * @return void .
	 */
	void setErrorArguments(Object... objects);

	/**
	 * @author:³ÂÊ¥Ê¥
	 * @return Object[] .
	 */
	Object[] getErrorArguments();

}
