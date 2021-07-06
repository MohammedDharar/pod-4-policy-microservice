package com.cognizant.pojo;

import java.util.Date;

public class Consumer {

	private Integer consumerId;

	private String firstName;

	private String lastName;

	private Date dob;

	private String businessName;

	private String panDetails;

	private String email;

	private String phone;

	private String address;

	private String agentName;

	private Integer agentId;

	public Consumer() {
		super();
	}
	
	

	public Consumer(Integer consumerId, String firstName, String lastName, Date dob, String businessName,
			String panDetails, String email, String phone, String address, String agentName, Integer agentId) {
		super();
		this.consumerId = consumerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.businessName = businessName;
		this.panDetails = panDetails;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.agentName = agentName;
		this.agentId = agentId;
	}



	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getAgentId() {
		return agentId;
	}

	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", businessName=" + businessName + ", panDetails=" + panDetails + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", agentName=" + agentName + ", agentId=" + agentId
				+ "]";
	}
}
