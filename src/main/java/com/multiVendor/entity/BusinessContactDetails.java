package com.multiVendor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.multiVendor.commonUtils.ActiveInActive;

@Entity
@Table(name="contact_details")
public class BusinessContactDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id")
	private Integer id;
	
	@Column(name = "ACTIVATION_STATUS")
	private Integer activationStatusID;

	@ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "BUSINESS_ID",foreignKey = @ForeignKey(name = "a_business_member_contact_details"))
    private Business businessProfile;
    
    @Column(name = "BUSINESS_ID", updatable = false, insertable = false)
	private Integer businessProfileId;
    
    @Column( name = "OWNER_NAME", nullable = false, length = 20 )
	private String ownerName;
	
	@Column( name = "OWNER_PHONE_NUMBER", nullable = true, length = 15)
	private String ownerphoneNumber;
	
	@Column( name = "OWNER_EMAIL", nullable = true, length = 100)
	private String ownerEmail;


	public BusinessContactDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusinessContactDetails(Integer id, Integer activationStatusID, Business businessProfile,
			Integer businessProfileId, String ownerName, String ownerphoneNumber, String ownerEmail) {
		super();
		this.id = id;
		this.activationStatusID = activationStatusID;
		this.businessProfile = businessProfile;
		this.businessProfileId = businessProfileId;
		this.ownerName = ownerName;
		this.ownerphoneNumber = ownerphoneNumber;
		this.ownerEmail = ownerEmail;
	}

	public Business getBusinessProfile() {
		return businessProfile;
	}

	public void setBusinessProfile(Business businessProfile) {
		this.businessProfile = businessProfile;
	}

	public Integer getBusinessProfileId() {
		return businessProfileId;
	}

	public void setBusinessProfileId(Integer businessProfileId) {
		this.businessProfileId = businessProfileId;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivationStatusID() {
		return activationStatusID;
	}

	public void setActivationStatusID(Integer activationStatusID) {
		this.activationStatusID = activationStatusID;
	}
	
	public ActiveInActive getActivationStatus() {
		return ActiveInActive.fromId(getActivationStatusID());
	}
	public void setActivationStatus(ActiveInActive activeInActive) {
		this.activationStatusID = activeInActive.getId();
	}
	
}
