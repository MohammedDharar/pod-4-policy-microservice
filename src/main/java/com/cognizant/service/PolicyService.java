package com.cognizant.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cognizant.exception.PolicyNotFoundException;
import com.cognizant.model.ConsumerPolicy;
import com.cognizant.model.PolicyMaster;
import com.cognizant.repository.ConsumerPolicyRepo;
import com.cognizant.repository.PolicyMasterRepo;

@Service
public class PolicyService {
	
	public PolicyService(PolicyMasterRepo policyMasterRepo,ConsumerPolicyRepo consumerPolicyRepo) {
		super();
		this.policyMasterRepo = policyMasterRepo;
		this.consumerPolicyRepo = consumerPolicyRepo;
	}

	private PolicyMasterRepo policyMasterRepo;
	private ConsumerPolicyRepo consumerPolicyRepo;
	
	private static final String PS1="PS1 - Unable to create your policy. Please check the data you have Entered";
	private static final String PS2="PS2 - Unable to create your policy. Please check the data you have Entered";
	private static final String PS3="PS3 - Policy-Master not found.  Please check the data you have Entered";
	private static final String PS4="PS4 - Policy-Master not found.  Please check the data you have Entered";
	private static final String PS5="PS5 - Consumer Policy not found.  Please check the data you have Entered.";
	private static final String PS6="PS6 - Consumer Policy not found. Please check the data you have Entered.";
	
	@Transactional
	public ConsumerPolicy saveConsumerPolicy(ConsumerPolicy consumerPolicy) throws PolicyNotFoundException {
		if(consumerPolicy!=null) {
		ConsumerPolicy policy =
				consumerPolicyRepo.save(consumerPolicy);
		
		if (policy == null) {

			throw new PolicyNotFoundException(
					PS1);

		}
		return consumerPolicy;
		}
		else {
			throw new PolicyNotFoundException(PS2);
		}
		
}
	
	@Transactional
	public PolicyMaster getPolicyMaster(Integer businessValue, Integer propertyValue) throws PolicyNotFoundException {
		if(businessValue==null || propertyValue==null || businessValue<0 || propertyValue<0 || businessValue>10 || propertyValue>10) {
			throw new PolicyNotFoundException(PS3);
		}
		PolicyMaster policyMaster= policyMasterRepo.findByBusinessValueAndPropertyValue(businessValue,propertyValue);
		
		if(policyMaster==null) {
			throw new PolicyNotFoundException(PS4);
		}
		return policyMaster;
	}
	
	@Transactional
	public ConsumerPolicy getPolicyDetails(Integer consumerId,Integer businessId) throws PolicyNotFoundException {
		if(consumerId==null || businessId==null) {
			throw new PolicyNotFoundException(PS5); 
		}
		
		ConsumerPolicy consumerPolicy= consumerPolicyRepo.findByConsumerIdAndBusinessId(consumerId,businessId);
		System.out.println(consumerPolicy);
		if(consumerPolicy==null) {
		
		throw new PolicyNotFoundException(PS6);
	}
		
		return consumerPolicy;
	}
}
