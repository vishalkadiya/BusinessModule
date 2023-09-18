package com.multiVendor.operation;

import org.springframework.http.ResponseEntity;
import com.multiVendor.view.BusinessView;

public interface BusinessOperation {

	ResponseEntity<Object> doSaveOperation(BusinessView businessView) throws Exception;

	ResponseEntity<Object> doUpdateOperation(BusinessView businessView) throws Exception;

	ResponseEntity<Object> doInactiveOperation(Integer id) throws Exception;

	ResponseEntity<Object> get(Integer id) throws Exception;

	ResponseEntity<Object> search(String companyName) throws Exception;

	ResponseEntity<Object> filterCity(String cityValue);

	ResponseEntity<Object> filterState(String stateValue);

	ResponseEntity<Object> filterTypeOfFirm(String typeOfFirm);

	ResponseEntity<Object> filterIndustry(String industry);

	ResponseEntity<Object> filterOrganisationSize(Integer min, Integer max);

	ResponseEntity<Object> filterAtoZ();

	ResponseEntity<Object> filterZtoA();

}
