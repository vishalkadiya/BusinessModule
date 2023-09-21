package com.multiVendor.validation;

import com.multiVendor.custom.CustomMessage;

public enum RegexEnum implements EnumType {
	ALPHABETS(1, "Alphabets", "^[a-zA-Z]+$", CustomMessage.APLHABETS),
	ALPHABETS_WITH_SPACE(2, "Albhabets with space", "^[A-Za-z\\s]+$", CustomMessage.APLHABETS_WITH_SPACE),
	ALPHA_NUMERIC(3, "Alpha-Numeric", "^[a-zA-Z0-9]+$", CustomMessage.ALPHA_NUMBERIC),
	ALPHA_NUMERIC_WITH_SPACE(4, "Alpha-Numeric with space", "^[a-zA-Z0-9\\s]+$",
			CustomMessage.ALPHA_NUMBERIC_WITH_SPACE),
	NUMERIC(5, "Numeric", "^[0-9]+$", CustomMessage.NUMBERS),
	COUNTRY_CODE(6, "Country Code", "^$|^[0-9]{2,4}$", CustomMessage.INVALID_COUNTRY_CODE),
	CONTACT_NUMBER(7, "Contact Number", "^$|^[0-9]{7,12}$", CustomMessage.INVALID_MOBILE_NUMBER),
	CONTACT_NUMBER_WITH_COUNTRY_CODE(14, "Contact Number", "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
			CustomMessage.INVALID_MOBILE_NUMBER),
	DESCRIPTION(8, "Description", "^[A-Za-z0-9]{1}[A-Za-z0-9._,\\(\\)\\s-]*$", CustomMessage.INVALID_DESCRIPTION),
	EMAIL(9, "Email",
			"^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.([a-z]{1,5})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$",
			CustomMessage.INVALID_EMAIL),
	CAPTIAL_ALPHABETS(10, "Captial Alphabets", "^[A-Z]+$", CustomMessage.CAPITAL_ALPHABETS),
	CAPTIAL_ALPHABETS_WITH_NUMBER(11, "Captial Alphabets with number", "^[A-Z0-9]+$",
			CustomMessage.CAPITAL_ALPHABETS_WITH_SPACE),
	USER_ID(12, "User Id",
			"^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.([a-z]{1,5})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$",
			CustomMessage.INVALID_EMAIL),
	PASSWORD(13, "Password", "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>])(?=\\S+$).{8,}$",
			CustomMessage.INVALID_PASSWORD);

	private final Integer id;
	private final String name;
	private final String value;
	private final String message;

	RegexEnum(Integer id, String name, String value, String message) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.message = message;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * This methods is used to fetch Enum base on given id.
	 * 
	 * @param id enum key
	 * @return RegexEnum enum
	 */
	public static RegexEnum fromId(long id) {
		for (RegexEnum regexEnum : values()) {
			if (regexEnum.getId() == id) {
				return regexEnum;
			}
		}
		return null;
	}

}