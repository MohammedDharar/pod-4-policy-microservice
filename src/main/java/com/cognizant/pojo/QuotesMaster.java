package com.cognizant.pojo;

public class QuotesMaster {

	private Integer id;
	private Integer businessValue;
	private Integer propertyValue;
	private String propertyType;
	private String quotes;

	public QuotesMaster() {
		super();
	}

	public QuotesMaster(Integer id, Integer businessValue, Integer propertyValue, String propertyType, String quotes) {
		super();
		this.id = id;
		this.businessValue = businessValue;
		this.propertyValue = propertyValue;
		this.propertyType = propertyType;
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "QuotesMaster [id=" + id + ", businessValue=" + businessValue + ", propertyValue=" + propertyValue
				+ ", propertyType=" + propertyType + ", quotes=" + quotes + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getQuotes() {
		return quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

}
