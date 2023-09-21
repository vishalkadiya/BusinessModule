package com.multiVendor.view;

import java.util.List;

public class BusinessView {

	private Integer id;

	private String companyName;

	private String address;

	private String city;

	private String state;

	private String countryCode;

	private String website;

	private String pinCode;

	private String industry;

	private Integer organisationSize;

	private String description;

	private String typeOfFirm;

	private String gstNumber;

	private List<BusinessContactDetailsView> contactDetails;

	private List<String> companyCityName;

	private List<String> companyStateName;

	private List<String> filterTypeOfFirm;

	private List<String> filterIndustry;

	private List<String> filterOrganisationSize;

	private List<String> filterAtoZ;

	private List<String> filterZtoA;

	public BusinessView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessView(Integer id, String companyName, String address, String city, String state, String countryCode,
			String website, String pinCode, String industry, Integer organisationSize, String description,
			String typeOfFirm, String gstNumber, List<BusinessContactDetailsView> contactDetails,
			List<String> companyCityName, List<String> companyStateName, List<String> filterTypeOfFirm,
			List<String> filterIndustry, List<String> filterOrganisationSize, List<String> filterAtoZ,
			List<String> filterZtoA) {
		super();
		this.id = id;
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
		this.companyCityName = companyCityName;
		this.companyStateName = companyStateName;
		this.filterTypeOfFirm = filterTypeOfFirm;
		this.filterIndustry = filterIndustry;
		this.filterOrganisationSize = filterOrganisationSize;
		this.filterAtoZ = filterAtoZ;
		this.filterZtoA = filterZtoA;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<BusinessContactDetailsView> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<BusinessContactDetailsView> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<String> getCompanyCityName() {
		return companyCityName;
	}

	public void setCompanyCityName(List<String> companyCityName) {
		this.companyCityName = companyCityName;
	}

	public List<String> getCompanyStateName() {
		return companyStateName;
	}

	public void setCompanyStateName(List<String> companyStateName) {
		this.companyStateName = companyStateName;
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

	public List<String> getFilterOrganisationSize() {
		return filterOrganisationSize;
	}

	public void setFilterOrganisationSize(List<String> filterOrganisationSize) {
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
