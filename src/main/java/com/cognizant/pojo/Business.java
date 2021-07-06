package com.cognizant.pojo;

public class Business {

	private Integer businessId;

	private Integer consumerId;

	private String businessCategory;

	private Long businessTurnOver;

	private Long capitalInvested;

	private Integer totalEmployees;

	private Integer businessValue;

	private Integer businessAge;

	public Business() {
		super();
	}

	public Integer getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(Integer businessValue) {
		this.businessValue = businessValue;
	}

	
	public Business(Integer businessId, Integer consumerId, String businessCategory, Long businessTurnOver,
			Long capitalInvested, Integer totalEmployees, Integer businessValue, Integer businessAge) {
		super();
		this.businessId = businessId;
		this.consumerId = consumerId;
		this.businessCategory = businessCategory;
		this.businessTurnOver = businessTurnOver;
		this.capitalInvested = capitalInvested;
		this.totalEmployees = totalEmployees;
		this.businessValue = businessValue;
		this.businessAge = businessAge;
	}

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", consumerId=" + consumerId + ", businessCategory="
				+ businessCategory + ", businessTurnOver=" + businessTurnOver + ", capitalInvested=" + capitalInvested
				+ ", totalEmployees=" + totalEmployees + ", businessValue=" + businessValue + ", businessAge="
				+ businessAge + "]";
	}

}