package com.multiVendor.commonUtils;

public enum ResponseCode {
	
	HTTP_UNAUTHORIZED(401, "Unauthorized User"), 
	ALREADY_EXIST(409, "Already Exist."),
	INVALID_FORM_DATA(1002, "Invalid Form Data."),
	SUCCESSFUL(1000, "Successful"), 
	NO_DATA_FOUND(1004, "No Data Found"),
	INTERNAL_SERVER_ERROR(500, "System is unable to process the request.");
	
	
	private final int code;
	private final String message;

	ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	/*
	 	This methods is used to fetch Enum base on given id.
	*/
	
	public static ResponseCode fromId(int code) {
		for (ResponseCode responseCode : values()) {
			if (responseCode.code == code) {
				return responseCode;
			}
		}
		return null;
	}
}
