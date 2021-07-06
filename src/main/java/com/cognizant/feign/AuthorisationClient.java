package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Proxy interface for authorization service
 */
@FeignClient(name = "authorization-service", url = "${AUTH_SERVICE:http://pod4authorization-env.eba-wpqvpigb.us-west-2.elasticbeanstalk.com/}")
public interface AuthorisationClient {

	/**
	 * Method for validating the token
	 * 
	 * @param token
	 * @return This returns true if token is valid else returns false
	 */
	@GetMapping("/auth/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
}
