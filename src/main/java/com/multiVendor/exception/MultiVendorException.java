package com.multiVendor.exception;

import java.util.Map;

import com.multiVendor.commonUtils.ResponseCode;

public class MultiVendorException extends Exception{
	
	private static final long serialVersionUID = 3628181483553738110L;
	private final int code;
	private final String message;
	private final Map<String, String> properties;
	private final String className;
	private final String transactionName;
	private final String identificationValue;
	
	
	
	public MultiVendorException(int code, Map<String, String> properties, String className, String transactionName){
		super(ResponseCode.fromId(code).getMessage());
		this.code = code;
		this.properties = properties;
		this.className = className;
		this.transactionName = transactionName;
		this.identificationValue="";
		this.message=ResponseCode.fromId(code).getMessage();
	}

	public MultiVendorException(int code2, String className2, String transactionName2) {
		super(ResponseCode.fromId(code2).getMessage());
		this.code = code2;
		this.properties = null;
		this.className = className2;
		this.transactionName = transactionName2;
		this.identificationValue="";
		this.message=ResponseCode.fromId(code).getMessage();	
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public String getClassName() {
		return className;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public String getIdentificationValue() {
		return identificationValue;
	}
	
	
	
}
