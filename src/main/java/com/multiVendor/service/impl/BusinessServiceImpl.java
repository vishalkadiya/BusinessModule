package com.multiVendor.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.multiVendor.entity.Business;
import com.multiVendor.repository.BusinessRepository;
import com.multiVendor.service.BusinessService;
import com.multiVendor.view.BusinessView;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	BusinessRepository businessRepository;
	
	@Override
	public void save(Business model) {
		businessRepository.save(model);
	}

	@Override
	public Business findByBusinessID(BusinessView businessView) {
		Business business = businessRepository.findById(businessView.getId()).get(); 
		return business;
	}

	@Override
	public Business getById(Integer id){
		Business business = businessRepository.findById(id).get();
		return business;
	}

	@Override
	public Business findByCompanyName(String companyName) {
		Business business = businessRepository.findByCompanyNameContaining(companyName);
		return business;
	}

	@Override
	public List<Business> findByCityName(Business model) {
		List<Business> businessList = new ArrayList<Business>();
		for(String cityName : model.getFilterCityName()) {
			List<Business> results = businessRepository.findByCityContaining(cityName);
			businessList.addAll(results);
		}
		return businessList;
	}

	@Override
	public List<Business> findByStateName(Business model) {
		List<Business> businessList = new ArrayList<Business>();
		for(String stateName : model.getFilterStateName()) {
			List<Business> results = businessRepository.findByStateContaining(stateName);
			businessList.addAll(results);
		}
		return businessList;
	}

	@Override
	public List<Business> findByTypeOfFirm(Business model) {
		List<Business> businessList = new ArrayList<Business>();
		for(String typeOfFirm : model.getFilterTypeOfFirm()) {
			List<Business> results = businessRepository.findByTypeOfFirmContaining(typeOfFirm);
			businessList.addAll(results);
		}
		return businessList;
	}

	@Override
	public List<Business> findByIndustry(Business model) {
		List<Business> businessList = new ArrayList<Business>();
		for(String industry : model.getFilterIndustry()) {
			List<Business> results = businessRepository.findByIndustryContaining(industry);
			businessList.addAll(results);
		}
		return businessList;
	}

	@Override
	public List<Business> findByOrganisation(Business model) {
		List<Business> businessList = new ArrayList<Business>();
		Integer minimum = model.getFilterOrganisationSize().get(0);
		Integer maximum = model.getFilterOrganisationSize().get(1);
		List<Business> results = businessRepository.findOrganisationByGreaterThanEqualANDLessThanEqual(minimum, maximum);
		businessList.addAll(results);
		return businessList;
	}

	@Override
	public List<Business> findAllAtoZ() {
		List<Business> allBusiness = new ArrayList<Business>();
		businessRepository.findAll(Sort.by(Sort.Direction.ASC, "companyName")).forEach(business -> allBusiness.add(business));
		return allBusiness;
	}

	@Override
	public List<Business> findAllZtoA() {
		List<Business> allBusiness = new ArrayList<Business>();
		businessRepository.findAll(Sort.by(Sort.Direction.DESC, "companyName")).forEach(business -> allBusiness.add(business));
		return allBusiness;
	}
	
}
