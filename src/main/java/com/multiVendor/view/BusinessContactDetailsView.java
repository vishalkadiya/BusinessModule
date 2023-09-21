package com.multiVendor.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.multiVendor.commonView.KeyValueView;

public class BusinessContactDetailsView {

	private KeyValueView businessProfile;

	private String ownerName;

	private String ownerphoneNumber;

	private String ownerEmail;

	@JsonIgnore
	@JsonProperty(value = "businessProfile")
	public KeyValueView getBusinessProfile() {
		return businessProfile;
	}

	public void setBusinessProfile(KeyValueView businessProfile) {
		this.businessProfile = businessProfile;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerphoneNumber() {
		return ownerphoneNumber;
	}

	public void setOwnerphoneNumber(String ownerphoneNumber) {
		this.ownerphoneNumber = ownerphoneNumber;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

}
