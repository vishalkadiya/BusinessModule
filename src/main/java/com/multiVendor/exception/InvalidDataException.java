package com.multiVendor.exception;

import java.util.Map;

public class InvalidDataException extends MultiVendorException {

	private static final long serialVersionUID = 2292655575130527999L;

	public InvalidDataException(int code, Map<String, String> properties, String className, String transactionName) {
		super(code, properties, className, transactionName);
	}

	public InvalidDataException(int code, String className, String transactionName) {
		super(code, className, transactionName);
	}
}
