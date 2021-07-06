package com.cognizant.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "consumer_policy")
@ApiModel(description = "Model Class for the Consumer Policy")
public class ConsumerPolicy {

	@Id
	@ApiModelProperty(value = "consumer Id Id of consumer")
	private Integer consumerId;

	@ApiModelProperty(value = "business Id of consumer")
	private Integer businessId;

	@ApiModelProperty(value = "policy Id of consumer")
	private String policyId;

	@ApiModelProperty(value = "property Type of consumer")
	private String propertyType;

	@ApiModelProperty(value = "consumer Type of consumer")
	private String consumerType;

	@ApiModelProperty(value = "covered Sum by policy for consumer")
	private Long coveredSum;

	@ApiModelProperty(value = "duration of policy for consumer")
	private String duration;

	@ApiModelProperty(value = "business Value of consumer")
	private Integer businessValue;

	@ApiModelProperty(value = "property Value of consumer")
	private Integer propertyValue;

	@ApiModelProperty(value = "base Location of consumer")
	private String baseLocation;

	@ApiModelProperty(value = "types of coverage")
	private String types;

	@ApiModelProperty(value = "status of policy for consumer")
	private String status;

	@ApiModelProperty(value = "acceptanceStatus of policy for consumer")
	private String acceptanceStatus;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@ApiModelProperty(value = "EffectiveDate of policy for consumer")
	private Date effectiveDate;

	@ApiModelProperty(value = "accepted Quotes from quotes master")
	private String acceptedQuotes;

	@ApiModelProperty(value = "payment Status of consumer")
	private String paymentStatus;

	@ApiModelProperty(value = "Agent Id of Agent")
	private Integer agentId;

	public ConsumerPolicy(Integer consumerId, Integer businessId, String policyId, String propertyType,
			String consumerType, Long coveredSum, String duration, Integer businessValue, Integer propertyValue,
			String baseLocation, String types, String status, String acceptanceStatus, Date effectiveDate,
			String acceptedQuotes, String paymentStatus, Integer agentId) {
		super();
		this.consumerId = consumerId;
		this.businessId = businessId;
		this.policyId = policyId;
		this.propertyType = propertyType;
		this.consumerType = consumerType;
		this.coveredSum = coveredSum;
		this.duration = duration;
		this.businessValue = businessValue;
		this.propertyValue = propertyValue;
		this.baseLocation = baseLocation;
		this.types = types;
		this.status = status;
		this.acceptanceStatus = acceptanceStatus;
		this.effectiveDate = effectiveDate;
		this.acceptedQuotes = acceptedQuotes;
		this.paymentStatus = paymentStatus;
		this.agentId = agentId;
	}

	

	public ConsumerPolicy() {
		super();
		
	}

	public Integer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

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

	public Long getCoveredSum() {
		return coveredSum;
	}

	public void setCoveredSum(Long coveredSum) {
		this.coveredSum = coveredSum;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAcceptanceStatus() {
		return acceptanceStatus;
	}

	public void setAcceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getAcceptedQuotes() {
		return acceptedQuotes;
	}

	public void setAcceptedQuotes(String acceptedQuotes) {
		this.acceptedQuotes = acceptedQuotes;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	
	@Override
	public String toString() {
		return "ConsumerPolicy [consumerId=" + consumerId + ", businessId=" + businessId + ", policyId=" + policyId
				+ ", propertyType=" + propertyType + ", consumerType=" + consumerType + ", coveredSum=" + coveredSum
				+ ", duration=" + duration + ", businessValue=" + businessValue + ", propertyValue=" + propertyValue
				+ ", baseLocation=" + baseLocation + ", types=" + types + ", status=" + status + ", acceptanceStatus="
				+ acceptanceStatus + ", effectiveDate=" + effectiveDate + ", acceptedQuotes=" + acceptedQuotes
				+ ", paymentStatus=" + paymentStatus + ", agentId=" + agentId + "]";
	}

}
