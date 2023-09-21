package com.multiVendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.multiVendor.entity.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {

	Business findByCompanyNameContaining(String companyName);

	List<Business> findByCityContaining(String cityName);

	List<Business> findByStateContaining(String stateName);

	List<Business> findByTypeOfFirmContaining(String typeOfFirm);

	List<Business> findByIndustryContaining(String industry);

	@Query(value = "SELECT * FROM business_details b WHERE b.organisation_size >= :minimum and b.organisation_size <= :maximum", nativeQuery = true)
	List<Business> findOrganisationByGreaterThanEqualANDLessThanEqual(@Param("minimum") Integer minimum,
			@Param("maximum") Integer maximum);

}
