package com.cts.Consumer_microservice.Test;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.Consumer_microservice.payload.request.ConsumerBusinessRequest;
import com.cts.Consumer_microservice.payload.response.messageResponse;
import com.cts.Consumer_microservice.service.consumerImpl;

public class testing {

	private static messageResponse createConsumerBusiness;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumerBusinessRequest consumerBusinessRequest=new ConsumerBusinessRequest();
		
		
		
		
		consumerImpl consumer=new consumerImpl();
		
		createConsumerBusiness = consumer.createConsumerBusiness(consumerBusinessRequest);
		System.out.println(createConsumerBusiness);
		
		

	}

}
