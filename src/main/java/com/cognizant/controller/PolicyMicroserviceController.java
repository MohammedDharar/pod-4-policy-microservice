package com.cognizant.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.PolicyNotFoundException;
import com.cognizant.feign.AuthorisationClient;
import com.cognizant.feign.ConsumerFeignClient;
import com.cognizant.feign.QuotesFeignClient;
import com.cognizant.model.ConsumerPolicy;
import com.cognizant.model.PolicyMaster;
import com.cognizant.pojo.Business;
import com.cognizant.pojo.Consumer;
import com.cognizant.pojo.Property;
import com.cognizant.pojo.QuotesMaster;
import com.cognizant.service.PolicyService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/policy-master")
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class PolicyMicroserviceController {
	
	
	public PolicyMicroserviceController(PolicyService policyService,
			QuotesFeignClient quotesFeignClient, ConsumerFeignClient consumer,
			AuthorisationClient authorisationClient) {
		super();
		
		this.policyService = policyService;
		this.quotesFeignClient = quotesFeignClient;
		this.consumer = consumer;
		this.authorisationClient = authorisationClient;
	}

	
	
	private PolicyService policyService;
	private QuotesFeignClient quotesFeignClient;
	private ConsumerFeignClient consumer;
	private AuthorisationClient authorisationClient;
	
	private static final String CREATE_STATUS="Initiated";
	private static final String ISSUE_STATUS="Issued";
	private static final String REJECTED_STSTUS="Rejected";
	private static final String PC1="PC1-Policy Not Found.";
	private static final String PC2="PC2-Policy Details Not Found.";
	private static final String PC3="PC3-Policy Details Not Found.";
	private static final String PC4="PC4-Quote Details Not Found.";


	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

	/*
	 * In createPolicy Input: Consumer Details, Business Details, Accepted Quotes,
	 * Agent Details Output: Policy Status, Description
	 */
	@PostMapping("/createPolicy/{consumerId}/{businessId}")
	@ApiOperation(value = "createPolicy", notes = "Creates policy for Consumer's Business", httpMethod = "POST", response = String.class)
	public ConsumerPolicy createPolicy(@RequestHeader(name = "Authorization") String token, @PathVariable Integer consumerId,
			@PathVariable Integer businessId) throws PolicyNotFoundException {

		if (authorisationClient.validate(token)) {
			log.info("Start Policy Creation");
			
			Consumer consumer1 = consumer.viewConsumer(token, consumerId);
			log.debug("Cosumer: {}", consumer1);
			
			Business business = consumer.viewbusiness(token, businessId);
			log.debug("business: {}", business);
			
			Property property = consumer.viewbusinessProperty(token, businessId);
			log.debug("property: {}", property);
			
			ConsumerPolicy consumerPolicy = new ConsumerPolicy();
			log.debug("Object of consumerpolicy: {}", consumerPolicy);
			
			consumerPolicy.setConsumerId(consumerId);
			log.debug("consumerId: {}", consumerId);
			
			consumerPolicy.setBusinessId(businessId);
			log.debug("businessId: {}", businessId);
			
			consumerPolicy.setAgentId(consumer1.getAgentId());
			
			log.debug("consumer1.getAgentId(): {}", consumer1.getAgentId());
			log.debug("business.getBusinessValue(): {}", business.getBusinessValue());
			log.debug("property.getPropertyValue(): {}", property.getPropertyValue());

			PolicyMaster master = new PolicyMaster();
			master = policyService.getPolicyMaster(business.getBusinessValue(), property.getPropertyValue());
			log.debug("businessId: {}", master);
			
			consumerPolicy.setPolicyId(master.getPolicyId());
			consumerPolicy.setPropertyType(master.getPropertyType());
			consumerPolicy.setConsumerType(master.getConsumerType());
			consumerPolicy.setCoveredSum(master.getAssuredSum());
			consumerPolicy.setDuration(master.getTenure());
			consumerPolicy.setBusinessValue(master.getBusinessValue());
			consumerPolicy.setPropertyValue(master.getPropertyValue());
			consumerPolicy.setBaseLocation(master.getBaseLocation());
			consumerPolicy.setTypes(master.getTypes());
			consumerPolicy.setStatus(CREATE_STATUS);
			consumerPolicy.setAcceptedQuotes(quotesFeignClient.getQuotesForPolicy(token, business.getBusinessValue(),
					property.getPropertyValue(), property.getPropertyType()));
			
			log.debug("AcceptedQuotes: {}", consumerPolicy.getAcceptedQuotes());
			
			log.debug("Object of consumerpolicy: {}", consumerPolicy);
			
			policyService.saveConsumerPolicy(consumerPolicy);
			
			log.info("End of Policy Creation");
			return consumerPolicy;
		} else {
			throw new PolicyNotFoundException(PC1);
		}
	}

	/*
	 * In issuePolicy Input: Policy_ID, Consumer ID, Business ID, Payment Details,
	 * Acceptance Status Output: Issue Status, Status Description
	 */
	@PostMapping("/issuePolicy/{policyId}/{consumerId}/{businessId}/{paymentStatus}/{acceptanceStatus}")
	@ApiOperation(value = "issuePolicy", notes = "Issues the Created policy for Consumer's Business", httpMethod = "POST", response = String.class)
	public ConsumerPolicy issuePolicy(@RequestHeader(name = "Authorization") String token, @PathVariable String policyId,
			@PathVariable Integer consumerId, @PathVariable Integer businessId, @PathVariable String paymentStatus,
			@PathVariable String acceptanceStatus) throws PolicyNotFoundException {
		if (authorisationClient.validate(token)) {
			log.info("Start Issue Policy");
			
			ConsumerPolicy consumerPolicy = policyService.getPolicyDetails(consumerId, businessId);
			
			if ("accepted".equalsIgnoreCase(acceptanceStatus)) {
				
				consumerPolicy.setEffectiveDate(new Date());
				consumerPolicy.setStatus(ISSUE_STATUS);
				consumerPolicy.setPaymentStatus(paymentStatus);
				consumerPolicy.setAcceptanceStatus(acceptanceStatus);
				policyService.saveConsumerPolicy(consumerPolicy);
				
				log.debug("consumerPolicy: {}", consumerPolicy);
				log.info("End Issue Policy");
				
				return consumerPolicy;
			} 
			else {
				consumerPolicy.setStatus(REJECTED_STSTUS);
				return consumerPolicy;
			}
		} else {
			throw new PolicyNotFoundException(PC2);
		}

	}

	/*
	 * In viewPolicy Input: Consumer ID, Policy ID Output: Policy Details
	 */
	@GetMapping("/viewPolicy/{consumerId}/{businessId}")
	@ApiOperation(value = "viewPolicy", notes = "Views policy created for Consumer's Business", httpMethod = "GET", response = ConsumerPolicy.class)
	public ConsumerPolicy viewPolicy(@RequestHeader(name = "Authorization") String token,
			@PathVariable Integer consumerId, @PathVariable Integer businessId) throws PolicyNotFoundException {
		if (authorisationClient.validate(token)) {
			
			log.info("Start View Policy");
			//log.debug("Policy Details: {}", policyService.getPolicyDetails(consumerId, policyId));
			log.info("End View Policy");
			
			return policyService.getPolicyDetails(consumerId, businessId);

		} else {
			throw new PolicyNotFoundException(PC3);
		}

	}

	/*
	 * In getQuotes Input: Business Value, Property Value Quotes details
	 */
	@GetMapping("/getQuotes/{business_Value}/{propertyValue}")
	@ApiOperation(value = "getQuotes", notes = "Views Quotes for Consumer's Business", httpMethod = "GET", response = QuotesMaster.class)
	public QuotesMaster getQuotes(@RequestHeader(name = "Authorization") String token,
			@PathVariable Integer business_Value, @PathVariable Integer propertyValue) throws PolicyNotFoundException {
		
		if (authorisationClient.validate(token)) {
			
			log.info("Start getQuotes");
			log.debug("Quotes Details: {}", quotesFeignClient.getQuotesDetails(token, business_Value, propertyValue));
			log.info("End getQuotes");
			
			return quotesFeignClient.getQuotesDetails(token, business_Value, propertyValue);
		} 
		else {
			throw new PolicyNotFoundException(PC4);
		}
	}



}
