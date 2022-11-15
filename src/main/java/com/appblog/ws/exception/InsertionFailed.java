package com.appblog.ws.exception;


public class InsertionFailed extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String resourceName;
	private String value;
	
	public InsertionFailed(String errorCode, String resourceName,String value) {
		super(String.format("%s : %s : %s",errorCode,resourceName,value));
		this.errorCode = errorCode;
		this.resourceName = resourceName;	
		this.value = value;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public String getResourceName() {
		return resourceName;
	}
	public String getValue() {
		return value;
	}

	

}