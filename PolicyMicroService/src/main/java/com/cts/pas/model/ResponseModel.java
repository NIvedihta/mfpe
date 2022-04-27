package com.cts.pas.model;

public class ResponseModel {

	private PolicyMaster policyMaster;
	private ConsumerPolicy consumerPolicy;
	public ResponseModel() {
		super();
	}
	public PolicyMaster getPolicyMaster() {
		return policyMaster;
	}
	public void setPolicyMaster(PolicyMaster policyMaster) {
		this.policyMaster = policyMaster;
	}
	public ConsumerPolicy getConsumerPolicy() {
		return consumerPolicy;
	}
	public ResponseModel(PolicyMaster policyMaster, ConsumerPolicy consumerPolicy) {
		super();
		this.policyMaster = policyMaster;
		this.consumerPolicy = consumerPolicy;
	}
	public void setConsumerPolicy(ConsumerPolicy consumerPolicy) {
		this.consumerPolicy = consumerPolicy;
	}
	
	
}
