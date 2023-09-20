package com.multiVendor.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import com.multiVendor.commonUtils.OperationName;
import com.multiVendor.commonUtils.ResponseCode;
import com.multiVendor.controller.BusinessController;
import com.multiVendor.exception.InvalidDataException;
import com.multiVendor.operation.BusinessOperation;
import com.multiVendor.validation.DataType;
import com.multiVendor.validation.InputField;
import com.multiVendor.validation.StaticFormValidator;
import com.multiVendor.view.BusinessView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/business")
public class BusinessControllerImpl implements BusinessController{
	
	@Autowired
	BusinessOperation businessOperation;
	
	public BusinessOperation businessOperation() {
		return businessOperation;
	}
	
	private static final Logger log = LogManager.getLogger(BusinessControllerImpl.class);


	private void isValidSaveData(BusinessView businessView) throws InvalidDataException {
		
		Map<String, String> errorProperties = new HashMap<>();
		
		commonValidation(businessView, errorProperties);
		
		if (!CollectionUtils.isEmpty(errorProperties)) {
			log.error(ResponseCode.INVALID_FORM_DATA.getCode() + " Invalid Form Data");
			throw new InvalidDataException(ResponseCode.INVALID_FORM_DATA.getCode(), errorProperties , this.getClass().getName(),
					OperationName.SAVE);
		}
	}
	
	private void isValidUpdateData(BusinessView businessView) throws InvalidDataException {

		Map<String, String> errorProperties = new HashMap<>();		

		commonValidation(businessView, errorProperties);
		
		if (!CollectionUtils.isEmpty(errorProperties)) {
			log.error(ResponseCode.INVALID_FORM_DATA.getCode() + " Invalid Form Data");
			throw new InvalidDataException(ResponseCode.INVALID_FORM_DATA.getCode(), errorProperties, this.getClass().getName(),
					OperationName.SAVE);
		}	
	}
	
	private void commonValidation(BusinessView businessView, Map<String, String> errorProperties) {
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("companyName", businessView.getCompanyName(), 
				DataType.STRING, 0, 100, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_NULL
		.isValid(new InputField("address", businessView.getAddress(), 
				DataType.STRING, 0, 0, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("city", businessView.getCity(), 
				DataType.STRING, 0, 20, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("state", businessView.getState(), 
				DataType.STRING, 0, 20, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("countryCode", businessView.getCountryCode(), 
				DataType.STRING, 0, 5, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("pinCode", businessView.getPinCode(), 
				DataType.STRING, 0, 10, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("industry", businessView.getIndustry(), 
				DataType.STRING, 0, 10, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("description", businessView.getDescription(), 
				DataType.STRING, 0, 500, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("typeOfFirm", businessView.getTypeOfFirm(), 
				DataType.STRING, 0, 10, null, errorProperties));
		
		StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
		.isValid(new InputField("gst number", businessView.getGstNumber(), 
				DataType.STRING, 0, 10, null, errorProperties));
		
	}

	@Override
	public ResponseEntity<Object> save(@RequestBody BusinessView businessView) throws Exception{
		
		try {
			isValidSaveData(businessView);
			return businessOperation.doSaveOperation(businessView);
		}
		finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.SAVE + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " saveCompany");
		}
	}

	@Override
	public ResponseEntity<Object> update(@RequestBody BusinessView businessView) throws Exception {
		try {
			isValidUpdateData(businessView);
			return businessOperation.doUpdateOperation(businessView);
		}
		finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.UPDATE + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " updateCompany");			
		}
	}

	@Override
	public ResponseEntity<Object> delete(@RequestParam("id") Integer id) throws Exception {
		try {
			return businessOperation().doInactiveOperation(id);
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.DELETE + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " deleteCompany");			
		}
	}

	@Override
	public ResponseEntity<Object> get(@RequestParam("id") Integer id) throws Exception {
		return businessOperation().get(id);
	}

	@Override
	public ResponseEntity<Object> search(@RequestParam("companyName") String companyName) throws Exception {
		try {
			if(companyName.isEmpty()) {
				throw new Exception("companyName is required");
			}
			return businessOperation().search(companyName);
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.SEARCH_TABLE + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " searchCompany");			
		}
	}

	@Override
	public ResponseEntity<Object> filterCity(@RequestParam("cityValue") String cityValue) throws Exception {
		try {
			if(cityValue.isEmpty()) {
				throw new Exception("cityName is required");
			}
			return businessOperation().filterCity(cityValue);
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.FILTER + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " filterCity");			
		}
	}

	@Override
	public ResponseEntity<Object> filterState(@RequestParam("stateValue") String stateValue) throws Exception {
		try {
			if(stateValue.isEmpty()) {
				throw new Exception("stateName is required");
			}
			return businessOperation().filterState(stateValue);
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.FILTER + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " filterState");
		}
	}

	@Override
	public ResponseEntity<Object> filterTypeOfFirm(@RequestParam("typeOfFirm") String typeOfFirm) throws Exception {
		try {
			if(typeOfFirm.isEmpty()) {
				throw new Exception("typeOfFirm is required");
			}
			return businessOperation().filterTypeOfFirm(typeOfFirm);
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.FILTER + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " filterTypeOfFirm");
		}
	}

	@Override
	public ResponseEntity<Object> filterIndusty(@RequestParam("industry") String industry) throws Exception {
		try {
			if(industry.isEmpty()) {
				throw new Exception("industryName is required");
			}
			return businessOperation().filterIndustry(industry);
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.FILTER + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " filterIndustry");
		}
	}

	@Override
	public ResponseEntity<Object> filterOrganisationSize(@RequestParam("min") Integer min, @RequestParam("max") Integer max) throws Exception {
		try {
			if(min.equals(null) && max.equals(null)) {
				throw new Exception("min & max values are required");	
			}
			return businessOperation().filterOrganisationSize(min, max);
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.FILTER + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " filterOrganisation-Size");
		}
	}

	@Override
	public ResponseEntity<Object> filterAtoZ() throws Exception {
		try {
			return businessOperation().filterAtoZ();
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.FILTER + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " A-to-Z");
		}
	}

	@Override
	public ResponseEntity<Object> filterZtoA() throws Exception {
		try {
			return businessOperation().filterZtoA();
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.FILTER + " " + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " Z-to-A");
		}
	}

}
