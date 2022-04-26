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
@Table(name = "Consumer")
@NoArgsConstructor
@AllArgsConstructor
public class consumer {
	
	public consumer() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "First_Name")
	private String firstname;

	@NotBlank
	@Size(max = 50)
	@Column(name = "Last_Name")
	private String lastname;

	@NotBlank
	@Size(max = 20)
	@Column(name = "DOB")
	private String dob;

	@NotBlank
	@Size(max = 50)
	@Column(name = "Business_Name")
	private String businessname;

	@NotBlank
	@Size(max = 12)
	@Column(name = "PAN_Details")
	private String pandetails;

	@NotBlank
	@Size(max = 50)
	@Column(name = "Email")
	private String email;

	@NotBlank
	@Size(max = 10)
	@Column(name = "Phone")
	private String phone;

	@NotBlank
	@Size(max = 40)
	@Column(name = "Website")
	private String website;

	@NotBlank
	@Size(max = 150)
	@Column(name = "Business_Overview")
	private String businessoverview;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Validity_of_Consumer")
	private String validity;

	@NotBlank
	@Size(max = 50)
	@Column(name = "Agent_Name")
	private String agentname;

	@NotNull
	@Column(name = "Agent_ID")
	private Long agentid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getPandetails() {
		return pandetails;
	}

	public void setPandetails(String pandetails) {
		this.pandetails = pandetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBusinessoverview() {
		return businessoverview;
	}

	public void setBusinessoverview(String businessoverview) {
		this.businessoverview = businessoverview;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public Long getAgentid() {
		return agentid;
	}

	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}

	public consumer(@NotBlank @Size(max = 50) String firstname, @NotBlank @Size(max = 50) String lastname,
			@NotBlank @Size(max = 20) String dob, @NotBlank @Size(max = 50) String businessname,
			@NotBlank @Size(max = 12) String pandetails, @NotBlank @Size(max = 50) String email,
			@NotBlank @Size(max = 10) String phone, @NotBlank @Size(max = 40) String website,
			@NotBlank @Size(max = 150) String businessoverview, @NotBlank @Size(max = 30) String validity,
			@NotBlank @Size(max = 50) String agentname, @NotNull Long agentid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.businessname = businessname;
		this.pandetails = pandetails;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.businessoverview = businessoverview;
		this.validity = validity;
		this.agentname = agentname;
		this.agentid = agentid;
	}

}