package com.multiVendor.service;

import com.multiVendor.entity.BusinessContactDetails;

public interface BusinessContactDetailsService {

	void save(BusinessContactDetails contactDetail);

	void findAllContacts(BusinessContactDetails contactDetail);

}
