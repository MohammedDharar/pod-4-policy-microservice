package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pojo.QuotesMaster;

@FeignClient(name = "quotes-service", url = "http://pod4quotesmicroservice-env.eba-pihq2uni.us-west-2.elasticbeanstalk.com/quotes-master")
public interface QuotesFeignClient {
	
	
	/*
	 * retrieves all the quotes from Quotes_Master
	 */
	@GetMapping("/getQuotesDetails/{businessValue}/{propertyValue}")
	public  QuotesMaster getQuotesDetails(@RequestHeader(name = "Authorization") String token,@PathVariable Integer businessValue, @PathVariable Integer propertyValue);
	
	/*
	 * retrieves the quotes from Quotes_Master by businessValue, propertyValue, PropertyType
	 */
	@GetMapping("/getQuotesForPolicy/{businessValue}/{propertyValue}/{propertyType}")
	public String getQuotesForPolicy(@RequestHeader(name = "Authorization") String token,@PathVariable Integer businessValue,@PathVariable Integer propertyValue,@PathVariable String propertyType);
}
