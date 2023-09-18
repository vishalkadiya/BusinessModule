package com.multiVendor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.multiVendor.view.BusinessView;

public interface BusinessController {
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> save(BusinessView businessView) throws Exception;
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> update(BusinessView businessView) throws Exception;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> delete(Integer id) throws Exception;
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> get(Integer id) throws Exception;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> search(String companyName) throws Exception;
	
	@RequestMapping(value = "/filter/city", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> filterCity(String cityValue) throws Exception;
	
	@RequestMapping(value = "/filter/state", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> filterState(String stateValue) throws Exception;
	
	@RequestMapping(value = "/filter/typeOfFirm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> filterTypeOfFirm(String typeOfFirm) throws Exception;
	
	@RequestMapping(value = "/filter/industry", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> filterIndusty(String industry) throws Exception;
	
	@RequestMapping(value = "/filter/organisation", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> filterOrganisationSize(Integer min, Integer max) throws Exception;
	
	@RequestMapping(value = "/filter/AtoZ", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> filterAtoZ() throws Exception;
	
	@RequestMapping(value = "/filter/ZtoA", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> filterZtoA() throws Exception;
	
	
}
