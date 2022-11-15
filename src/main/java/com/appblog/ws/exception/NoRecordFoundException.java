package com.appblog.ws.exception;

public class NoRecordFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String resourceName;
	
	
	
	public NoRecordFoundException(String errorCode, String resourceName) {
		super(String.format("%s : %s ", errorCode,resourceName));
		this.errorCode = errorCode;
		this.resourceName = resourceName;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public String getResourceName() {
		return resourceName;
	}

}
