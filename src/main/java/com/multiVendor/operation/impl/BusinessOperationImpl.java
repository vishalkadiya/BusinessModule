package com.multiVendor.operation.impl;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.multiVendor.service.BusinessContactDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.multiVendor.commonUtils.ActiveInActive;
import com.multiVendor.commonUtils.LoggerService;
import com.multiVendor.commonUtils.OperationName;
import com.multiVendor.commonUtils.ResponseCode;
import com.multiVendor.entity.Business;
import com.multiVendor.entity.BusinessContactDetails;
import com.multiVendor.exception.InvalidDataException;
import com.multiVendor.operation.BusinessOperation;
import com.multiVendor.service.BusinessService;
import com.multiVendor.validation.DataType;
import com.multiVendor.validation.InputField;
import com.multiVendor.validation.RegexEnum;
import com.multiVendor.validation.StaticFormValidator;
import com.multiVendor.view.BusinessContactDetailsView;
import com.multiVendor.view.BusinessView;

@Component
public class BusinessOperationImpl implements BusinessOperation {

	@Autowired
	BusinessService businessService;

	@Autowired
	BusinessContactDetailsService businessContactDetails;

	private static final Logger log = LogManager.getLogger(BusinessOperationImpl.class);

	public BusinessService getService() {
		return businessService;
	}

	private Business toModel(Business model, BusinessView businessView) {
		if (!businessView.getCompanyName().isEmpty()) {
			model.setCompanyName(businessView.getCompanyName());
		}
		if (!businessView.getAddress().isEmpty()) {
			model.setAddress(businessView.getAddress());
		}
		if (!businessView.getCity().isEmpty()) {
			model.setCity(businessView.getCity());
		}
		if (!businessView.getState().isEmpty()) {
			model.setState(businessView.getState());
		}
		if (!businessView.getCountryCode().isEmpty()) {
			model.setCountryCode(businessView.getCountryCode());
		}
		if (!businessView.getWebsite().isEmpty()) {
			model.setWebsite(businessView.getWebsite());
		}
		if (!businessView.getPinCode().isEmpty()) {
			model.setPinCode(businessView.getPinCode());
		}
		if (!businessView.getIndustry().isEmpty()) {
			model.setIndustry(businessView.getIndustry());
		}
		if (!(businessView.getOrganisationSize() == null)) {
			model.setOrganisationSize(businessView.getOrganisationSize());
		}
		if (!businessView.getDescription().isEmpty()) {
			model.setDescription(businessView.getDescription());
		}
		if (!businessView.getTypeOfFirm().isEmpty()) {
			model.setTypeOfFirm(businessView.getTypeOfFirm());
		}

		model.setGstNumber(businessView.getGstNumber());
		return model;

	}

	@Override
	public ResponseEntity<Object> doSaveOperation(BusinessView businessView) throws Exception {
		Business model = new Business();
		try {
			beforeSave(model, businessView);
			model = toModel(model, businessView);
			getService().save(model);
			afterSave(model, businessView);
			return ResponseEntity.ok(fromModel(model));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void beforeSave(Business model, BusinessView businessView) {
		model.setActivationStatus(ActiveInActive.ACTIVE);
	}

	private void afterSave(Business model, BusinessView businessView) throws InvalidDataException {

		if (!CollectionUtils.isEmpty(businessView.getContactDetails())) {
			List<BusinessContactDetails> contactDetails = new ArrayList<BusinessContactDetails>();
			for (BusinessContactDetailsView contactDetailsView : businessView.getContactDetails()) {

				Map<String, String> errorProperties = new HashMap<>();

				if (contactDetailsView.getOwnerEmail() != null) {
					StaticFormValidator.VALIDATE_NAME
							.isValid(new InputField("emailId", contactDetailsView.getOwnerEmail(), DataType.STRING, 3,
									100, RegexEnum.EMAIL, errorProperties));
				}
				if (contactDetailsView.getOwnerphoneNumber() != null) {
					StaticFormValidator.VALIDATE_NAME.isValid(new InputField("contactNumber",
							contactDetailsView.getOwnerphoneNumber(), DataType.STRING, 10, 15,
							RegexEnum.CONTACT_NUMBER, errorProperties));
				}

				if (!CollectionUtils.isEmpty(errorProperties)) {
					log.error(LoggerService.ERROR + this.getClass().getSimpleName() + " " + OperationName.SAVE
							+ errorProperties + " Invalid data");
					throw new InvalidDataException(ResponseCode.INVALID_CONTACT_DETAILS.getCode(), errorProperties,
							this.getClass().getName(),
							OperationName.SAVE);
				}

				BusinessContactDetails contactDetail = new BusinessContactDetails();

				contactDetail.setBusinessProfile(model);
				contactDetail.setOwnerName(contactDetailsView.getOwnerName());
				contactDetail.setOwnerphoneNumber(contactDetailsView.getOwnerphoneNumber());
				contactDetail.setOwnerEmail(contactDetailsView.getOwnerEmail());
				contactDetail.setActivationStatus(ActiveInActive.ACTIVE);
				contactDetails.add(contactDetail);
				businessContactDetails.save(contactDetail);
				model.setContactDetails(contactDetails);

			}
		}
	}

	private BusinessView fromModel(Business model) {
		BusinessView view = new BusinessView();
		view.setId(model.getId());
		view.setCompanyName(model.getCompanyName());
		view.setAddress(model.getAddress());
		view.setCity(model.getCity());
		view.setCity(model.getCity());
		view.setState(model.getState());
		view.setCountryCode(model.getCountryCode());
		view.setWebsite(model.getWebsite());
		view.setPinCode(model.getPinCode());
		view.setIndustry(model.getIndustry());
		view.setOrganisationSize(model.getOrganisationSize());
		view.setDescription(model.getDescription());
		view.setTypeOfFirm(model.getTypeOfFirm());
		view.setGstNumber(model.getGstNumber());
		List<BusinessContactDetailsView> contactDetails = new ArrayList<BusinessContactDetailsView>();

		for (BusinessContactDetails contactDetail : model.getContactDetails()) {

			BusinessContactDetailsView contactDetailView = new BusinessContactDetailsView();
			contactDetailView.setOwnerName(contactDetail.getOwnerName());
			contactDetailView.setOwnerphoneNumber(contactDetail.getOwnerphoneNumber());
			contactDetailView.setOwnerEmail(contactDetail.getOwnerEmail());
			contactDetails.add(contactDetailView);
			view.setContactDetails(contactDetails);

		}
		return view;
	}

	@Override
	public ResponseEntity<Object> doUpdateOperation(BusinessView businessView) throws Exception {
		try {
			Business model = loadModel(businessView);
			if (model == null) {
				log.error("Review not found");
				throw new InvalidDataException(ResponseCode.NO_DATA_FOUND.getCode(), this.getClass().getName(),
						OperationName.FETCH_OPERATION);
			}
			if (ActiveInActive.ACTIVE != model.getActivationStatus()) {
				log.error(
						ResponseCode.INTERNAL_SERVER_ERROR.getCode() + ResponseCode.INTERNAL_SERVER_ERROR.getMessage());
			}
			// beforeUpdate(model, businessView);
			model = toModel(model, businessView);
			getService().save(model);
			afterSave(model, businessView);
			return ResponseEntity.ok(fromModel(model));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.UPDATE + " "
					+ com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " updateCompany");
		}
	}

	// private void beforeUpdate(Business model, BusinessView businessView) {
	// model.setActivationStatus(ActiveInActive.ACTIVE);
	// }

	private Business loadModel(BusinessView businessView) {
		return getService().findByBusinessID(businessView);
	}

	@Override
	public ResponseEntity<Object> doInactiveOperation(Integer id) throws Exception {
		Business model = new Business();
		try {
			model = getService().getById(id);
			if (model == null) {
				log.error("Company data not found");
				throw new InvalidDataException(ResponseCode.NO_DATA_FOUND.getCode(), this.getClass().getName(),
						OperationName.SEARCH_TABLE);
			}
			model.setActivationStatus(ActiveInActive.INACTIVE);
			getService().save(model);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.DELETE + " "
					+ com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " deleteCompany");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("User is successfully deleted");
	}

	@Override
	public ResponseEntity<Object> get(Integer id) throws Exception {
		Business model = new Business();
		try {
			model = getService().getById(id);
			if (model == null) {
				log.error("Company data not found");
				throw new InvalidDataException(ResponseCode.NO_DATA_FOUND.getCode(), this.getClass().getName(),
						OperationName.SEARCH_TABLE);
			}
			List<BusinessContactDetails> contactDetails = new ArrayList<BusinessContactDetails>();
			BusinessContactDetails contactDetail = new BusinessContactDetails();
			contactDetail.setBusinessProfile(model);
			businessContactDetails.findAllContacts(contactDetail);
			contactDetails.add(contactDetail);
			model.setContactDetails(contactDetails);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.GET_OPERATION + " "
					+ com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " getCompany");
		}
		return ResponseEntity.ok(fromModel(model));
	}

	@Override
	public ResponseEntity<Object> search(String companyName) throws Exception {
		Business model = new Business();
		try {
			model = getService().findByCompanyName(companyName);
			if (model == null) {
				log.error("Company data not found");
				throw new InvalidDataException(ResponseCode.NO_DATA_FOUND.getCode(), this.getClass().getName(),
						OperationName.SEARCH_TABLE);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.SEARCH_OPERATION + " "
					+ com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " searchCompany");
		}
		return ResponseEntity.ok(fromModel(model));
	}

	@Override
	public ResponseEntity<Object> filterCity(String cityValue) {
		Business model = new Business();

		List<Business> businessList = new ArrayList<Business>();

		List<String> cityValues = new ArrayList<String>();
		cityValues.add(cityValue);
		model.setFilterCityName(cityValues);
		businessList.addAll(getService().findByCityName(model));

		List<BusinessView> businessView = new ArrayList<BusinessView>();
		for (Business business : businessList) {
			businessView.add(fromModel(business));
		}
		return ResponseEntity.ok(businessView);
	}

	@Override
	public ResponseEntity<Object> filterState(String stateValue) {
		Business model = new Business();

		List<Business> businessList = new ArrayList<Business>();

		List<String> stateValues = new ArrayList<String>();
		stateValues.add(stateValue);
		model.setFilterStateName(stateValues);
		businessList.addAll(getService().findByStateName(model));

		List<BusinessView> businessView = new ArrayList<BusinessView>();
		for (Business business : businessList) {
			businessView.add(fromModel(business));
		}
		return ResponseEntity.ok(businessView);
	}

	@Override
	public ResponseEntity<Object> filterTypeOfFirm(String typeOfFirm) {
		Business model = new Business();

		List<Business> businessList = new ArrayList<Business>();

		List<String> typeOfFirms = new ArrayList<String>();
		typeOfFirms.add(typeOfFirm);
		model.setFilterTypeOfFirm(typeOfFirms);
		businessList.addAll(getService().findByTypeOfFirm(model));

		List<BusinessView> businessView = new ArrayList<BusinessView>();
		for (Business business : businessList) {
			businessView.add(fromModel(business));
		}
		return ResponseEntity.ok(businessView);
	}

	@Override
	public ResponseEntity<Object> filterIndustry(String industry) {
		Business model = new Business();

		List<Business> businessList = new ArrayList<Business>();

		List<String> industies = new ArrayList<String>();
		industies.add(industry);
		model.setFilterIndustry(industies);
		businessList.addAll(getService().findByIndustry(model));

		List<BusinessView> businessView = new ArrayList<BusinessView>();
		for (Business business : businessList) {
			businessView.add(fromModel(business));
		}
		return ResponseEntity.ok(businessView);
	}

	@Override
	public ResponseEntity<Object> filterOrganisationSize(Integer min, Integer max) {
		Business model = new Business();

		List<Business> businessList = new ArrayList<Business>();

		List<Integer> organisation = new ArrayList<Integer>();
		organisation.add(min);
		organisation.add(max);
		model.setFilterOrganisationSize(organisation);
		businessList.addAll(getService().findByOrganisation(model));

		List<BusinessView> businessView = new ArrayList<BusinessView>();
		for (Business business : businessList) {
			businessView.add(fromModel(business));
		}
		return ResponseEntity.ok(businessView);
	}

	@Override
	public ResponseEntity<Object> filterAtoZ() {
		List<Business> businessList = new ArrayList<Business>();
		List<BusinessView> businessView = new ArrayList<BusinessView>();

		businessList.addAll(getService().findAllAtoZ());

		for (Business business : businessList) {
			businessView.add(fromModel(business));
		}
		return ResponseEntity.ok(businessView);
	}

	@Override
	public ResponseEntity<Object> filterZtoA() {
		List<Business> businessList = new ArrayList<Business>();
		List<BusinessView> businessView = new ArrayList<BusinessView>();

		businessList.addAll(getService().findAllZtoA());

		for (Business business : businessList) {
			businessView.add(fromModel(business));
		}

		return ResponseEntity.ok(businessView);
	}

}
