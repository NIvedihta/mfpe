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
@Table(name = "Business")
@NoArgsConstructor
@AllArgsConstructor
public class business {
	
	

	public business() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotNull
	@Column(name = "Consumer_ID")
	private Long consumerId;

	@NotBlank
	@Size(max = 40)
	@Column(name = "Business_Category")
	private String businesscategory;

	@NotBlank
	@Size(max = 40)
	@Column(name = "Business_Type")
	private String businesstype;

	@NotNull
	@Column(name = "Business_Turnover")
	private Long businessturnover;

	@NotNull
	@Column(name = "Capital_Invested ")
	private Long capitalinvested;

	@NotNull
	@Column(name = "Total_Employees")
	private Long totalemployees;

	@NotNull
	@Column(name = "Business_Value")
	private Long businessvalue;

	@NotNull
	@Column(name = "Business_Age")
	private Long businessage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getBusinesscategory() {
		return businesscategory;
	}

	public void setBusinesscategory(String businesscategory) {
		this.businesscategory = businesscategory;
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	public Long getBusinessturnover() {
		return businessturnover;
	}

	public void setBusinessturnover(Long businessturnover) {
		this.businessturnover = businessturnover;
	}

	public Long getCapitalinvested() {
		return capitalinvested;
	}

	public void setCapitalinvested(Long capitalinvested) {
		this.capitalinvested = capitalinvested;
	}

	public Long getTotalemployees() {
		return totalemployees;
	}

	public void setTotalemployees(Long totalemployees) {
		this.totalemployees = totalemployees;
	}

	public Long getBusinessvalue() {
		return businessvalue;
	}

	public void setBusinessvalue(Long businessvalue) {
		this.businessvalue = businessvalue;
	}

	public Long getBusinessage() {
		return businessage;
	}

	public void setBusinessage(Long businessage) {
		this.businessage = businessage;
	}

	public business(@NotNull Long consumerId, @NotBlank @Size(max = 40) String businesscategory,
			@NotBlank @Size(max = 40) String businesstype, @NotNull Long businessturnover,
			@NotNull Long capitalinvested, @NotNull Long totalemployees, @NotNull Long businessvalue,
			@NotNull Long businessage) {
		super();
		this.consumerId = consumerId;
		this.businesscategory = businesscategory;
		this.businesstype = businesstype;
		this.businessturnover = businessturnover;
		this.capitalinvested = capitalinvested;
		this.totalemployees = totalemployees;
		this.businessvalue = businessvalue;
		this.businessage = businessage;
	}

}