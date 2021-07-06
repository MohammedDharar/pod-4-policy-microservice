package com.cognizant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.cognizant.model.PolicyMaster;
import com.cognizant.repository.PolicyMasterRepo;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class PolicyMicroserviceApplication implements CommandLineRunner {

	public PolicyMicroserviceApplication(PolicyMasterRepo policyMasterRepo) {
		super();
		this.policyMasterRepo = policyMasterRepo;
	}

	private PolicyMasterRepo policyMasterRepo;

	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroserviceApplication.class, args);

	}

	/**
	 * ConfigureSwagger2
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket configureSwagger2() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/policy-master/**"))
				.apis(RequestHandlerSelectors.basePackage("com.cognizant")).build();
	}

	@Override
	public void run(String... args) throws Exception {

		policyMasterRepo.save(
				new PolicyMaster("P01", "Building", "Owner", 20000000L, "3 years", 8, 5, "Chennai", "Replacement"));
		policyMasterRepo.save(new PolicyMaster("P02", "Factory Equipment", "Owner", 400000L, "1 year", 9, 10, "Chennai",
				"Replacement"));
		policyMasterRepo.save(
				new PolicyMaster("P03", "Property in Transit", "Owner", 200000L, "1 week", 7, 8, "Pune", "Pay Back"));
		policyMasterRepo.save(
				new PolicyMaster("P04", "Property in Transit", "Owner", 2000L, "1 week", 2, 6, "Pune", "Pay Back"));
	}
}
