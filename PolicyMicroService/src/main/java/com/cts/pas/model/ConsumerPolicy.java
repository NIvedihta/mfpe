package com.cts.pas.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * Consumer Policy Entity Class
 * 
 */
@Entity
public class ConsumerPolicy {
	
	



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	
	@Column(name = "Consumer_ID")
	private Long consumerId;
	
	
	@Column(name = "Policy_ID")
	private String policyId;
	
	
	@Column(name = "Business_ID")
	private Long businessId;
	
	@Column(name = "Payment_Details")
	private String paymentDetails;
	
	
	@Column(name = "Acceptance_Status")
	private String acceptanceStatus;
	
	
	@Column(name = "Policy_Status")
	private String policyStatus;
	
	
	@Column(name = "Effective_Date")
	private String effectiveDate;
	
	
	@Column(name = "coveredSum")
	private String coveredSum;
	
	
	
	@Column(name = "Duration")
	private String duration;
	
	
	@Column(name = "Accepted_Quotes")
	private String acceptedQuote;
	
	

	public ConsumerPolicy() {
		super();
	}



	



	public ConsumerPolicy(Long id, Long consumerId, String policyId, Long businessId, String paymentDetails,
			String acceptanceStatus, String policyStatus, String effectiveDate, String coveredSum, String duration,
			String acceptedQuote) {
		super();
		this.id = id;
		this.consumerId = consumerId;
		this.policyId = policyId;
		this.businessId = businessId;
		this.paymentDetails = paymentDetails;
		this.acceptanceStatus = acceptanceStatus;
		this.policyStatus = policyStatus;
		this.effectiveDate = effectiveDate;
		this.coveredSum = coveredSum;
		this.duration = duration;
		this.acceptedQuote = acceptedQuote;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getconsumerId() {
		return consumerId;
	}



	public void setconsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}



	public String getpolicyId() {
		return policyId;
	}



	public void setpolicyId(String policyId) {
		this.policyId = policyId;
	}



	public Long getbusinessId() {
		return businessId;
	}



	public void setbusinessId(Long businessId) {
		this.businessId = businessId;
	}



	public String getpaymentDetails() {
		return paymentDetails;
	}



	public void setpaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}



	public String getacceptanceStatus() {
		return acceptanceStatus;
	}



	public void setacceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}



	public String getpolicyStatus() {
		return policyStatus;
	}



	public void setpolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}



	public String geteffectiveDate() {
		return effectiveDate;
	}



	public void seteffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}



	public String getcoveredSum() {
		return coveredSum;
	}



	public void setcoveredSum(String coveredSum) {
		this.coveredSum = coveredSum;
	}



	public String getDuration() {
		return duration;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}



	public String getacceptedQuote() {
		return acceptedQuote;
	}



	public void setacceptedQuote(String acceptedQuote) {
		this.acceptedQuote = acceptedQuote;
	}



	@Override
	public String toString() {
		return "ConsumerPolicy [id=" + id + ", consumerId=" + consumerId + ", policyId=" + policyId + ", businessId="
				+ businessId + ", paymentDetails=" + paymentDetails + ", acceptanceStatus=" + acceptanceStatus
				+ ", policyStatus=" + policyStatus + ", effectiveDate=" + effectiveDate + ", coveredSum=" + coveredSum
				+ ", duration=" + duration + ", acceptedQuote=" + acceptedQuote + "]";
	}



	


	
	
}

