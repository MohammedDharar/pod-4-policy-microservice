package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.PolicyMaster;


@Repository
public interface PolicyMasterRepo extends JpaRepository<PolicyMaster,String>{
		
	

	public PolicyMaster findByBusinessValueAndPropertyValue(Integer businessValue, Integer propertyValue);
}
