package com.cognizant.pojo;

public class Property {
	

	private Integer id;

	private Integer businessId; 

	private String insuranceType;

	private String propertyType;

	private Long annualDepreciationValue;

	private Integer propertyValue;

	private String buildingsqft;

	private String buildingType;

	private Integer buildingAge;

	private Long costOfAsset;

	private Long salvageValue;

	private Integer usefulLifeOfAsset;
	
	

	
	

	public Property() {
		super();
		
	}



	

	public Property(Integer id, Integer businessId, String insuranceType, String propertyType,
			Long annualDepreciationValue, Integer propertyValue, String buildingsqft, String buildingType,
			Integer buildingAge, Long costOfAsset, Long salvageValue, Integer usefulLifeOfAsset) {
		super();
		this.id = id;
		this.businessId = businessId;
		this.insuranceType = insuranceType;
		this.propertyType = propertyType;
		this.annualDepreciationValue = annualDepreciationValue;
		this.propertyValue = propertyValue;
		this.buildingsqft = buildingsqft;
		this.buildingType = buildingType;
		this.buildingAge = buildingAge;
		this.costOfAsset = costOfAsset;
		this.salvageValue = salvageValue;
		this.usefulLifeOfAsset = usefulLifeOfAsset;
	}





	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Integer propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	
	@Override
	public String toString() {
		return "Property [id=" + id + ", businessId=" + businessId + ", insuranceType=" + insuranceType
				+ ", propertyType=" + propertyType + ", annualDepreciationValue=" + annualDepreciationValue
				+ ", propertyValue=" + propertyValue + ", buildingsqft=" + buildingsqft + ", buildingType="
				+ buildingType + ", buildingAge=" + buildingAge + ", costOfAsset=" + costOfAsset + ", salvageValue="
				+ salvageValue + ", usefulLifeOfAsset=" + usefulLifeOfAsset + "]";
	}
	

}