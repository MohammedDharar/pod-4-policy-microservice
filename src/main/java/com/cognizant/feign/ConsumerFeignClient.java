package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pojo.Business;
import com.cognizant.pojo.Consumer;
import com.cognizant.pojo.Property;



@FeignClient(name = "consumer-service", url = "http://pod4consumermicroservice-env.eba-3ywqei4d.us-west-2.elasticbeanstalk.com/consumer")
public interface ConsumerFeignClient {
	
	@GetMapping("/viewbusinessProperty/{businessId}")
	public Property viewbusinessProperty(@RequestHeader(name = "Authorization") String token, @PathVariable Integer businessId);

	// policy---need
	@GetMapping("/viewbusiness/{businessId}")
	public Business viewbusiness(@RequestHeader(name = "Authorization") String token, @PathVariable Integer businessId);

	// policy---need
	@GetMapping("/viewConsumer/{consumerId}")
	public Consumer viewConsumer(@RequestHeader(name = "Authorization") String token, @PathVariable Integer consumerId); 

	}
