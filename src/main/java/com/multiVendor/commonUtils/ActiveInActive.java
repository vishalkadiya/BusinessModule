package com.multiVendor.commonUtils;

import com.multiVendor.validation.EnumType;

public enum ActiveInActive implements EnumType {

	INACTIVE(0, "INACTIVE"),
	ACTIVE(1, "ACTIVE"),
	INAPPROPRIATE(2,"INAPPROPRIATE"),
	MARKASINAPPROPRIATE(3,"MARKASINAPPROPRIATE"),
	MARKASVERIFIED(4,"MARKASVERIFIED"),
	NEEDTOVALIDATE(5,"NEEDTOVALIDATE"),
	DRAFT(9,"DRAFT"),
	ARCHIVED(10,"ARCHIVED");
	
	private final Integer id;
    private final String name;

	private ActiveInActive(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ActiveInActive fromId(Integer id) {
        for (ActiveInActive status : values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        return null;
    }
}
