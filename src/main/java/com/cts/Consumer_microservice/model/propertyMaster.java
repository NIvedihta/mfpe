package com.cts.Consumer_microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Property_Master")

@NoArgsConstructor
@AllArgsConstructor
public class propertyMaster {

	@Override
	public String toString() {
		return "propertyMaster [id=" + id + ", insurancetype=" + insurancetype + ", propertytype=" + propertytype
				+ ", buildingtype=" + buildingtype + ", buildingage=" + buildingage + "]";
	}

	public propertyMaster(Long id, @NotBlank @Size(max = 30) String insurancetype,
			@NotBlank @Size(max = 30) String propertytype, @NotBlank @Size(max = 7) String buildingtype,
			@NotNull Long buildingage) {
		super();
		this.id = id;
		this.insurancetype = insurancetype;
		this.propertytype = propertytype;
		this.buildingtype = buildingtype;
		this.buildingage = buildingage;
	}

	public propertyMaster() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Insurance_Type")
	private String insurancetype;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Property_Type")
	private String propertytype;

	@NotBlank
	@Size(max = 7)
	@Column(name = "Building_Type")
	private String buildingtype;

	@NotNull
	@Column(name = "Building_Age")
	private Long buildingage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getBuildingtype() {
		return buildingtype;
	}

	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}

	public Long getBuildingage() {
		return buildingage;
	}

	public void setBuildingage(Long buildingage) {
		this.buildingage = buildingage;
	}

}