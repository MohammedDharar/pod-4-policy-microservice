package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "policy_master")
@ApiModel(description = "Model Class for the Policy Master")
public class PolicyMaster {
	

	
    public PolicyMaster() {
		super();
		
	}

	public PolicyMaster(String policyId, String propertyType, String consumerType, Long assuredSum, String tenure,
			Integer businessValue, Integer propertyValue, String baseLocation, String types) {
		super();
		this.policyId = policyId;
		this.propertyType = propertyType;
		this.consumerType = consumerType;
		this.assuredSum = assuredSum;
		this.tenure = tenure;
		this.businessValue = businessValue;
		this.propertyValue = propertyValue;
		this.baseLocation = baseLocation;
		this.types = types;
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    //@ApiModelProperty(value = "Id of Policy Master")
    private Integer id;
    
    @Id
	@ApiModelProperty(value = "Id of policy Id")
	private String policyId;
	
	@ApiModelProperty(value = "property Type of the Policy Master")
	private String propertyType;
	
	@ApiModelProperty(value = "consumer Type of the Policy Master")
	private String consumerType;
	
	@ApiModelProperty(value = "assured Sum of the Policy Master")
	private Long assuredSum;
	
	@ApiModelProperty(value = "tenure of the Policy Master")
	private String tenure;
	
	
	@ApiModelProperty(value = "business Value of the Policy Master")
	private Integer businessValue;
	
	@ApiModelProperty(value = "property Value of the Policy Master")
	private Integer propertyValue;
	
	@ApiModelProperty(value = "base Location of the Policy Master")
	private String baseLocation;
	
	@ApiModelProperty(value = "types of the Policy Master")
	private String types;

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getConsumerType() {
		return consumerType;
	}

	public void setConsumerType(String consumerType) {
		this.consumerType = consumerType;
	}

	public Long getAssuredSum() {
		return assuredSum;
	}

	public void setAssuredSum(Long assuredSum) {
		this.assuredSum = assuredSum;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public Integer getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(Integer businessValue) {
		this.businessValue = businessValue;
	}

	public Integer getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Integer propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "PolicyMaster ["+"policyId=" + policyId + ", propertyType=" + propertyType
				+ ", consumerType=" + consumerType + ", assuredSum=" + assuredSum + ", tenure=" + tenure
				+ ", businessValue=" + businessValue + ", propertyValue=" + propertyValue + ", baseLocation="
				+ baseLocation + ", types=" + types + "]";
	}
	

}
