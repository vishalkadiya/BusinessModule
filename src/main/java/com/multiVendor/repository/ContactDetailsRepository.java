package com.multiVendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiVendor.entity.Business;
import com.multiVendor.entity.BusinessContactDetails;

@Repository
public interface ContactDetailsRepository extends JpaRepository<BusinessContactDetails, Integer>{

	
	void findAllByBusinessProfile(Business businessProfile);

	void findAllByBusinessProfile(Integer id);

}
