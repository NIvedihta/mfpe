package com.cts.pas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pas.model.ConsumerPolicy;
import com.cts.pas.model.PolicyMaster;
import com.cts.pas.model.PolicyRequest;
import com.cts.pas.model.ResponseModel;
import com.cts.pas.repository.ConsumerPolicyRepository;
import com.cts.pas.repository.PolicyMasterRepository;

@RestController
public class ViewPolicyController {

	
	
	@Autowired
	PolicyMasterRepository policyMasterRepository;
	@Autowired
	ConsumerPolicyRepository consumerPolicyRepository;
	
	
	
	@GetMapping("/viewPolicy")
	public ResponseEntity<ResponseModel> viewPolicy(@RequestBody PolicyRequest policyRequest) {
		ResponseModel responseModel=new ResponseModel();
		ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerIdAndPolicyId(policyRequest.getConsumerId(), policyRequest.getPolicyId());
		PolicyMaster policyMaster = policyMasterRepository.findByPolicyId(policyRequest.getPolicyId());
		if(consumerPolicy==null)
		{
			//return "No consumer and policy found ";
		}
		//String response="Policy Id: "+cp.getpolicyId()+" Consumer Id: "+cp.getconsumerId()+" Business Id:"+cp.getbusinessId()+" Payment Details: "+cp.getpaymentDetails()+" Acceptance Status: "+cp.getacceptanceStatus()+" Covered Sum: "+cp.getcoveredSum();
		responseModel.setConsumerPolicy(consumerPolicy);
		responseModel.setPolicyMaster(policyMaster);
		return ResponseEntity.ok(responseModel);
	
	}
}
