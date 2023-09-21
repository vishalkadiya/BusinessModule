package com.multiVendor.validation;

import com.multiVendor.custom.CustomMessage;

public enum StaticFormValidator implements EnumType {

	VALIDATE_NAME(2, "VALIDATE_NAME") {
		@Override
		public boolean isValid(InputField inputField) {
			if (ValidationType.NOT_NULL.isValid(inputField) == false
					|| ValidationType.MAX_LENGTH.isValid(inputField) == false
					|| ValidationType.REGEX.isValid(inputField) == false) {
				return false;
			}
			return true;
		}
	},
	VALIDATE_STRING_NULL(3, "VALIDATE_STRING_NULL") {
		@Override
		public boolean isValid(InputField inputField) {
			if (ValidationType.NOT_NULL.isValid(inputField) == false) {
				return false;
			}
			return true;
		}
	},
	VALIDATE_INTEGER(4, "VALIDATE_INTEGER") {
		@Override
		public boolean isValid(InputField inputField) {
			if (ValidationType.NOT_NULL.isValid(inputField) == false
					|| ValidationType.REGEX.isValid(inputField) == false) {
				return false;
			}
			return true;
		}
	},
	VALIDATE_INTEGER_LENGTH(5, "VALIDATE_INTEGER_LENGTH") {
		@Override
		public boolean isValid(InputField inputField) {
			if (ValidationType.NOT_NULL.isValid(inputField) == false
					|| ValidationType.MAX_LENGTH.isValid(inputField) == false
					|| ValidationType.REGEX.isValid(inputField) == false) {
				return false;
			}
			return true;
		}
	},
	VALIDATE_USER_NAME(6, "VALIDATE_USER_NAME") {
		@Override
		public boolean isValid(InputField inputField) {
			if (ValidationType.NOT_NULL.isValid(inputField) == false
					|| ValidationType.MAX_LENGTH.isValid(inputField) == false) {
				return false;
			} else if (inputField.getValue().matches(RegexEnum.USER_ID.getValue())) {
				return true;
			}
			/*
			 * else if(inputField.getValue().matches(RegexEnum.CONTACT_NUMBER.getValue())){
			 * return true; }
			 */
			inputField.getErrorProperties().put(inputField.getName(), CustomMessage.INVALID_USER_ID);
			return false;
		}
	},
	VALIDATE_MIN_MAX_REGEX(7, "VALIDATE_CONTACT_NUMBER") {
		@Override
		public boolean isValid(InputField inputField) {
			if (ValidationType.NOT_NULL.isValid(inputField) == false
					|| ValidationType.MIN_LENGTH.isValid(inputField) == false
					|| ValidationType.MAX_LENGTH.isValid(inputField) == false
					|| ValidationType.REGEX.isValid(inputField) == false) {
				return false;
			}
			return true;
		}
	},
	VALIDATE_STRING_WITHOUT_REGEX(8, "VALIDATE_STRING") {
		@Override
		public boolean isValid(InputField inputField) {
			if (ValidationType.NOT_NULL.isValid(inputField) == false
					|| ValidationType.MAX_LENGTH.isValid(inputField) == false) {
				return false;
			}
			return true;
		}
	};

	private final Integer id;
	private final String name;

	StaticFormValidator(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * This methods is used to fetch Enum base on given id.
	 * 
	 * @param code enum key
	 * @return CommonStatus enum
	 */
	public static StaticFormValidator fromId(int id) {
		for (StaticFormValidator staticFormValidator : values()) {
			if (staticFormValidator.getId() == id) {
				return staticFormValidator;
			}
		}
		return null;
	}

	/**
	 * This method is called by enum to check given field value is valid or not.
	 * 
	 * @param inputField
	 * @return boolean
	 */
	public abstract boolean isValid(InputField inputField);

}
