package com.multiVendor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.multiVendor.commonUtils.ActiveInActive;

@Entity
@Table(name="business_details")
public class Business {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id")
	private Integer id;
	
	@Column(name = "ACTIVATION_STATUS")
	private Integer activationStatusID;
	
	@Column( name = "COMPANY_NAME", nullable = false, length = 50 )
	private String companyName;
	
	@Column( name = "ADDRESS", nullable = false, length = 500 )
	private String address;
	
	@Column( name = "CITY", nullable = false, length = 20 )
	private String city;
	
	@Column( name = "STATE", nullable = false, length = 20 )
	private String state;
	
	@Column( name = "COUNTRY_CODE",insertable = true, nullable = false, length = 5 )
	private String countryCode;
	
	@Column( name = "WEBSITE", nullable = true, length = 30 )
	private String website;
	
	@Column(name = "PIN_CODE", nullable = false)
	private String pinCode;
	
	@Column( name = "INDUSTRY", nullable = true, length = 150)
	private String industry;
	
	@Column( name = "ORGANISATION_SIZE", insertable = true, updatable = false )
	private Integer organisationSize;
	
	@Column( name = "DESCRIPTION", nullable = false, length = 500 )
	private String description;
	
	@Column( name = "TYPE_OF_FIRM", insertable = true, updatable = false )
	private String typeOfFirm;
	
	@Column( name = "GST_NUMBER", nullable = true, length = 15)
	private String gstNumber;
	
	@OneToMany( mappedBy = "businessProfile")
	private List<BusinessContactDetails> contactDetails;
	
	@Transient
	private List<String> filterCityName;
	
	@Transient
	private List<String> filterStateName;
	
	@Transient
	private List<String> filterTypeOfFirm;
	
	@Transient
	private List<String> filterIndustry;
	
	@Transient
	private List<Integer> filterOrganisationSize;
	
	@Transient
	private List<String> filterAtoZ;
	
	@Transient
	private List<String> filterZtoA;

	public Business(Integer id, Integer activationStatusID, String companyName, String address, String city,
			String state, String countryCode, String website, String pinCode, String industry, Integer organisationSize,
			String description, String typeOfFirm, String gstNumber, List<BusinessContactDetails> contactDetails,
			List<String> filterCityName, List<String> filterStateName, List<String> filterTypeOfFirm,
			List<String> filterIndustry, List<Integer> filterOrganisationSize, List<String> filterAtoZ,
			List<String> filterZtoA) {
		super();
		this.id = id;
		this.activationStatusID = activationStatusID;
		this.companyName = companyName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.countryCode = countryCode;
		this.website = website;
		this.pinCode = pinCode;
		this.industry = industry;
		this.organisationSize = organisationSize;
		this.description = description;
		this.typeOfFirm = typeOfFirm;
		this.gstNumber = gstNumber;
		this.contactDetails = contactDetails;
		this.filterCityName = filterCityName;
		this.filterStateName = filterStateName;
		this.filterTypeOfFirm = filterTypeOfFirm;
		this.filterIndustry = filterIndustry;
		this.filterOrganisationSize = filterOrganisationSize;
		this.filterAtoZ = filterAtoZ;
		this.filterZtoA = filterZtoA;
	}

	public Business() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getOrganisationSize() {
		return organisationSize;
	}

	public void setOrganisationSize(Integer organisationSize) {
		this.organisationSize = organisationSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeOfFirm() {
		return typeOfFirm;
	}

	public void setTypeOfFirm(String typeOfFirm) {
		this.typeOfFirm = typeOfFirm;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public List<BusinessContactDetails> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<BusinessContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	public ActiveInActive getActivationStatus() {
		return ActiveInActive.fromId(getActivationStatusID());
	}
	public void setActivationStatus(ActiveInActive activeInActive) {
		this.activationStatusID = activeInActive.getId();
	}

	public List<String> getFilterCityName() {
		return filterCityName;
	}

	public void setFilterCityName(List<String> filterCityName) {
		this.filterCityName = filterCityName;
	}

	public List<String> getFilterStateName() {
		return filterStateName;
	}

	public void setFilterStateName(List<String> filterStateName) {
		this.filterStateName = filterStateName;
	}

	public List<String> getFilterTypeOfFirm() {
		return filterTypeOfFirm;
	}

	public void setFilterTypeOfFirm(List<String> filterTypeOfFirm) {
		this.filterTypeOfFirm = filterTypeOfFirm;
	}

	public List<String> getFilterIndustry() {
		return filterIndustry;
	}

	public void setFilterIndustry(List<String> filterIndustry) {
		this.filterIndustry = filterIndustry;
	}
	
	public List<Integer> getFilterOrganisationSize() {
		return filterOrganisationSize;
	}

	public void setFilterOrganisationSize(List<Integer> filterOrganisationSize) {
		this.filterOrganisationSize = filterOrganisationSize;
	}

	public List<String> getFilterAtoZ() {
		return filterAtoZ;
	}

	public void setFilterAtoZ(List<String> filterAtoZ) {
		this.filterAtoZ = filterAtoZ;
	}

	public List<String> getFilterZtoA() {
		return filterZtoA;
	}

	public void setFilterZtoA(List<String> filterZtoA) {
		this.filterZtoA = filterZtoA;
	}

}
