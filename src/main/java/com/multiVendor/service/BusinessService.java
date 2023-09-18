package com.multiVendor.service;

import java.util.List;
import com.multiVendor.entity.Business;
import com.multiVendor.view.BusinessView;

public interface BusinessService {

	void save(Business model);

	Business findByBusinessID(BusinessView businessView);

	Business getById(Integer id);

	Business findByCompanyName(String companyName);

	List<Business> findByCityName(Business model);

	List<Business> findByStateName(Business model);

	List<Business> findByTypeOfFirm(Business model);

	List<Business> findByIndustry(Business model);

	List<Business> findByOrganisation(Business model);

	List<Business> findAllAtoZ();

	List<Business> findAllZtoA();

}
