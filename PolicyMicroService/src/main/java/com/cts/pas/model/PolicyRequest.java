package com.cts.pas.model;

public class PolicyRequest {
	private String policyId;
	private long consumerId;
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public long getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	public PolicyRequest(String policyId, long consumerId) {
		super();
		this.policyId = policyId;
		this.consumerId = consumerId;
	}
	

}
