package com.appblog.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;

//	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
//		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.fieldValue = fieldValue;
//	}

	public RecordNotFoundException(String errorCode, String resourceName) {
		super(String.format("%s :  %s no record found ", errorCode, resourceName));
		this.errorCode = errorCode;
		this.resourceName = resourceName;
	}

	public RecordNotFoundException(String errorCode, String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s :  %s not found with %s : '%s'", errorCode, resourceName, fieldName, fieldValue));
		this.errorCode = errorCode;
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}

//
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//public class RecordNotFoundException extends RuntimeException {
//
//	private static final long serialVersionUID = 1L;
//	private String errorCode;
//	private String resourceName;
//	private String fieldName;
//	private Object fieldValue;
//	
////	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
////		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
////		this.resourceName = resourceName;
////		this.fieldName = fieldName;
////		this.fieldValue = fieldValue;
////	}
//	
//	public RecordNotFoundException(String errorCode,String resourceName, String fieldName, Object fieldValue) {
//		super(String.format("%s :  %s not found with %s : '%s'", errorCode, resourceName, fieldName, fieldValue));
//		this.errorCode = errorCode;
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.fieldValue = fieldValue;
//	}
//	
//	public String getErrorCode() {
//		return errorCode;
//	}
//	public String getResourceName() {
//		return resourceName;
//	}
//	
//	public String getFieldName() {
//		return fieldName;
//	}
//	
//	public Object getFieldValue() {
//		return fieldValue;
//	}
//	
//}