package com.appblog.ws.errorcodes;


import lombok.Data;

@Data
public class ErrorCodes {
	
	public static String idNotFound = "601";
	public static String noRecordFound = "602";
	public static String insertionFailed = "603";
	
	public static String roleNotAllowed = "605"; 

}
