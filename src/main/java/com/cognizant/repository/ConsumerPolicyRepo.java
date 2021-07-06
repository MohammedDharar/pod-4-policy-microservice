package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.ConsumerPolicy;

@Repository
public interface ConsumerPolicyRepo extends JpaRepository<ConsumerPolicy, Integer>{

	
	public ConsumerPolicy findByConsumerIdAndBusinessId(Integer consumerId,Integer businessId);
	

}
