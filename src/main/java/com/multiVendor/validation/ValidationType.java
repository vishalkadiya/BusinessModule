package com.multiVendor.validation;

import com.multiVendor.custom.CustomMessage;

public enum ValidationType implements EnumType, Validator {

	NOT_NULL(1, "NOT NULL") {

		@SuppressWarnings("deprecation")
		@Override
		public boolean isValid(InputField inputField) {
			if (org.springframework.util.StringUtils.isEmpty(inputField.getValue())
					|| org.springframework.util.StringUtils.isEmpty(inputField.getValue().trim())) {
				inputField.getErrorProperties().put(inputField.getName(), CustomMessage.FIELD_REQUIRED);
				return false;
			}
			return true;
		}

	},

	MIN_LENGTH(2, "MIN_LENGTH") {

		@Override
		public boolean isValid(InputField inputField) {

			if (NOT_NULL.isValid(inputField) == false) {
				return false;
			}

			if (inputField.getDataType() == DataType.STRING
					&& inputField.getValue().length() < inputField.getMinLength()) {
				inputField.getErrorProperties().put(inputField.getName(),
						CustomMessage.MIN_LENGTH + " " + inputField.getMinLength());
				return false;
			} else if (inputField.getDataType() == DataType.INT
					&& Integer.parseInt(inputField.getValue()) < inputField.getMinLength()) {
				inputField.getErrorProperties().put(inputField.getName(),
						CustomMessage.MIN_LENGTH + " " + inputField.getMinLength());
				return false;
			} else if (inputField.getDataType() == DataType.FLOAT
					&& Float.parseFloat(inputField.getValue()) < inputField.getMinLength()) {
				inputField.getErrorProperties().put(inputField.getName(),
						CustomMessage.MIN_LENGTH + " " + inputField.getMinLength());
				return false;
			}
			return true;
		}
	},

	MAX_LENGTH(3, "MAX_LENGTH") {

		@Override
		public boolean isValid(InputField inputField) {
			if (inputField.getDataType() == DataType.STRING
					&& inputField.getValue().length() > inputField.getMaxLength()) {
				inputField.getErrorProperties().put(inputField.getName(),
						CustomMessage.MAX_LENGTH + " " + inputField.getMaxLength());
				return false;
			} else if (inputField.getDataType() == DataType.INT
					&& Integer.parseInt(inputField.getValue()) > inputField.getMaxLength()) {
				inputField.getErrorProperties().put(inputField.getName(),
						CustomMessage.MAX_LENGTH + " " + inputField.getMaxLength());
				return false;
			} else if (inputField.getDataType() == DataType.FLOAT
					&& Float.parseFloat(inputField.getValue()) > inputField.getMaxLength()) {
				inputField.getErrorProperties().put(inputField.getName(),
						CustomMessage.MAX_LENGTH + " " + inputField.getMaxLength());
				return false;
			}
			return true;
		}
	},

	REGEX(4, "REGEX") {

		@Override
		public boolean isValid(InputField inputField) {

			if (NOT_NULL.isValid(inputField) == false) {
				return false;
			}

			if (inputField.getValue().matches(inputField.getRegex().getValue()) == false) {
				inputField.getErrorProperties().put(inputField.getName(), inputField.getRegex().getMessage());
				return false;
			}
			return true;

		}
	};

	private final Integer id;
	private final String name;

	ValidationType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * This methods is used to fetch Enum base on given id.
	 */
	public static ValidationType fromId(long id) {
		for (ValidationType staticFormValidator : values()) {
			if (staticFormValidator.getId() == id) {
				return staticFormValidator;
			}
		}
		return null;
	}

	/**
	 * This method is called by enum to check given field value is valid or not.
	 */
	public abstract boolean isValid(InputField inputField);

}
