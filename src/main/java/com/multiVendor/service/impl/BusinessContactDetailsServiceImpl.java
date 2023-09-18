package com.multiVendor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multiVendor.entity.BusinessContactDetails;
import com.multiVendor.repository.ContactDetailsRepository;
import com.multiVendor.service.BusinessContactDetailsService;

@Service
public class BusinessContactDetailsServiceImpl implements BusinessContactDetailsService{
	
	@Autowired
	ContactDetailsRepository contactDetailsRepo;

	@Override
	public void save(BusinessContactDetails contactDetails) {
		contactDetailsRepo.save(contactDetails);
	}

	@Override
	public void findAllContacts(BusinessContactDetails contactDetail) {
		contactDetailsRepo.findAllByBusinessProfile(contactDetail.getBusinessProfile());
	}
	
}
