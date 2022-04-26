package com.cts.Consumer_microservice.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class BusinessPropertyDetails {
	
	
	@NotNull
	private Long propertyId;
	
	@NotNull
	private Long businessId;
	
	@NotNull
	private Long consumerId;
	
	@NotBlank
	@Size(max = 30)
	private String insurancetype;
	
	@NotBlank
	@Size(max = 30)
	private String propertytype;
	
	@NotBlank
	@Size(max = 30)
	private String buildingsqft;
	
	@NotBlank
	@Size(max = 7)
	private String buildingtype;
	
	@NotBlank
	@Size(max = 10)
	private String buildingstoreys;
	
	@NotNull
	private Long buildingage;

	@NotNull
	private Long costoftheasset;
	
	@NotNull
	private Long salvagevalue;
	
	@NotNull
	private Long usefullifeoftheAsset;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getInsurancetype() {
		return insurancetype;
	}

	public void setInsurancetype(String insurancetype) {
		this.insurancetype = insurancetype;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public String getBuildingsqft() {
		return buildingsqft;
	}

	public void setBuildingsqft(String buildingsqft) {
		this.buildingsqft = buildingsqft;
	}

	public String getBuildingtype() {
		return buildingtype;
	}

	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}

	public String getBuildingstoreys() {
		return buildingstoreys;
	}

	public void setBuildingstoreys(String buildingstoreys) {
		this.buildingstoreys = buildingstoreys;
	}

	public Long getBuildingage() {
		return buildingage;
	}

	public void setBuildingage(Long buildingage) {
		this.buildingage = buildingage;
	}

	public Long getCostoftheasset() {
		return costoftheasset;
	}

	public void setCostoftheasset(Long costoftheasset) {
		this.costoftheasset = costoftheasset;
	}

	public Long getSalvagevalue() {
		return salvagevalue;
	}

	public void setSalvagevalue(Long salvagevalue) {
		this.salvagevalue = salvagevalue;
	}

	public Long getUsefullifeoftheAsset() {
		return usefullifeoftheAsset;
	}

	public void setUsefullifeoftheAsset(Long usefullifeoftheAsset) {
		this.usefullifeoftheAsset = usefullifeoftheAsset;
	}

	public BusinessPropertyDetails(@NotNull Long propertyId, @NotNull Long businessId, @NotNull Long consumerId,
			@NotBlank @Size(max = 30) String insurancetype, @NotBlank @Size(max = 30) String propertytype,
			@NotBlank @Size(max = 30) String buildingsqft, @NotBlank @Size(max = 7) String buildingtype,
			@NotBlank @Size(max = 10) String buildingstoreys, @NotNull Long buildingage, @NotNull Long costoftheasset,
			@NotNull Long salvagevalue, @NotNull Long usefullifeoftheAsset) {
		super();
		this.propertyId = propertyId;
		this.businessId = businessId;
		this.consumerId = consumerId;
		this.insurancetype = insurancetype;
		this.propertytype = propertytype;
		this.buildingsqft = buildingsqft;
		this.buildingtype = buildingtype;
		this.buildingstoreys = buildingstoreys;
		this.buildingage = buildingage;
		this.costoftheasset = costoftheasset;
		this.salvagevalue = salvagevalue;
		this.usefullifeoftheAsset = usefullifeoftheAsset;
	}

	public BusinessPropertyDetails() {
		super();
	}

	@Override
	public String toString() {
		return "BusinessPropertyDetails [propertyId=" + propertyId + ", businessId=" + businessId + ", consumerId="
				+ consumerId + ", insurancetype=" + insurancetype + ", propertytype=" + propertytype + ", buildingsqft="
				+ buildingsqft + ", buildingtype=" + buildingtype + ", buildingstoreys=" + buildingstoreys
				+ ", buildingage=" + buildingage + ", costoftheasset=" + costoftheasset + ", salvagevalue="
				+ salvagevalue + ", usefullifeoftheAsset=" + usefullifeoftheAsset + "]";
	}
	
	

}
