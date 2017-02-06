package com.css.framework.exception;

/**
 * �쳣���� ����deppon�쳣��
 * 
 * @author ��ʥʥ date 2017-02-05 17:00
 */
public interface IException {

	/**
	 * @author:��ʥʥ
	 * @return String .
	 */
	String getErrorCode();

	/**
	 * @author:��ʥʥ
	 * @return String .
	 */
	String getNativeMessage();

	/**
	 * @author:��ʥʥ
	 * @return void .
	 */
	void setErrorArguments(Object... objects);

	/**
	 * @author:��ʥʥ
	 * @return Object[] .
	 */
	Object[] getErrorArguments();

}
