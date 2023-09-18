package com.multiVendor.validation;

import java.util.Map;

public class InputField {
	private String name;
	private String value;
	private DataType dataType;
	private int minLength;
	private int maxLength;
	private RegexEnum regex;
	private Map<String, String> errorProperties;
	
	
	
	public InputField(String name, String value, DataType dataType, int minLength, int maxLength,
			RegexEnum regex, Map<String, String> errorProperties) {
		super();
		this.value = value;
		this.name = name;
		this.dataType = dataType;
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.regex = regex;
		this.errorProperties = errorProperties;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public int getMinLength() {
		return minLength;
	}
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public RegexEnum getRegex() {
		return regex;
	}
	public void setRegex(RegexEnum regex) {
		this.regex = regex;
	}
	
	public Map<String, String> getErrorProperties() {
		return errorProperties;
	}
	public void setErrorProperties(Map<String, String> errorProperties) {
		this.errorProperties = errorProperties;
	}
}
