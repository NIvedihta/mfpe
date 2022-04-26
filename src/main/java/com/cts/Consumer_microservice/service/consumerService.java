package com.cts.Consumer_microservice.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cts.Consumer_microservice.model.property;
import com.cts.Consumer_microservice.payload.request.BusinessPropertyRequest;
import com.cts.Consumer_microservice.payload.request.ConsumerBusinessRequest;
import com.cts.Consumer_microservice.payload.response.BusinessPropertyDetails;
import com.cts.Consumer_microservice.payload.response.ConsumerBusinessDetails;
import com.cts.Consumer_microservice.payload.response.messageResponse;





@Service
public interface consumerService {

	messageResponse createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest);

	Long calBusinessValue(Long businessturnover,Long capitalinvested);

	Boolean checkBusinessEligibility(ConsumerBusinessRequest consumerBusinessRequest) throws Exception;
	
	Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset);

	Boolean checkPropertyEligibility(String propertytype, String insurancetype, String buildingtype, Long buildingage) throws Exception;

	messageResponse updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails);

	ConsumerBusinessDetails viewConsumerBusiness(Long consumerid);

	messageResponse createBusinessProperty(BusinessPropertyRequest businessPropertyRequest);

	messageResponse updateBusinessProperty(BusinessPropertyDetails businessPropertyDetails);

	property viewConsumerProperty(Long consumerid, Long propertyid);
	

}