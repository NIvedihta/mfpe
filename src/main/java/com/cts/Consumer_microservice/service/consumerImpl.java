package com.cts.Consumer_microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Consumer_microservice.exceptions.BusinessPropertyNotFoundException;
import com.cts.Consumer_microservice.exceptions.ConsumerBusinessNotFoundException;
import com.cts.Consumer_microservice.model.business;
import com.cts.Consumer_microservice.model.businessMaster;
import com.cts.Consumer_microservice.model.consumer;
import com.cts.Consumer_microservice.model.property;
import com.cts.Consumer_microservice.model.propertyMaster;
import com.cts.Consumer_microservice.payload.request.BusinessPropertyRequest;
import com.cts.Consumer_microservice.payload.request.ConsumerBusinessRequest;
import com.cts.Consumer_microservice.payload.response.BusinessPropertyDetails;
import com.cts.Consumer_microservice.payload.response.ConsumerBusinessDetails;
import com.cts.Consumer_microservice.payload.response.messageResponse;
import com.cts.Consumer_microservice.repository.PropertyMasterRepository;
import com.cts.Consumer_microservice.repository.PropertyRepository;
import com.cts.Consumer_microservice.repository.buisnessRepository;
import com.cts.Consumer_microservice.repository.businessMasterRepository;
import com.cts.Consumer_microservice.repository.consumerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class consumerImpl implements consumerService {

	@Autowired
	consumerRepository consumerRepository;

	@Autowired
	buisnessRepository businessRepository;

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	businessMasterRepository businessMasterRepository;

	@Autowired
	PropertyMasterRepository propertyMasterRepository;

	@Override
	public messageResponse createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) {
		// TODO Auto-generated method stub
		consumer consumer = new consumer(consumerBusinessRequest.getFirstname(), consumerBusinessRequest.getLastname(),
				consumerBusinessRequest.getDob(), consumerBusinessRequest.getBusinessname(),
				consumerBusinessRequest.getPandetails(), consumerBusinessRequest.getEmail(),
				consumerBusinessRequest.getPhone(), consumerBusinessRequest.getWebsite(),
				consumerBusinessRequest.getBusinessoverview(), consumerBusinessRequest.getValidity(),
				consumerBusinessRequest.getAgentname(), consumerBusinessRequest.getAgentid());

		consumer consumersave = consumerRepository.save(consumer);
		Long businessvalue = calBusinessValue(consumerBusinessRequest.getBusinessturnover(),
				consumerBusinessRequest.getCapitalinvested());
		business business = new business(consumersave.getId(), consumerBusinessRequest.getBusinesscategory(),
				consumerBusinessRequest.getBusinesstype(), consumerBusinessRequest.getBusinessturnover(),
				consumerBusinessRequest.getCapitalinvested(), consumerBusinessRequest.getTotalemployees(),
				businessvalue, consumerBusinessRequest.getBusinessage());
		business businesssave = businessRepository.save(business);
		return new messageResponse("SuccessFully Created Consumer with Consumer ID :" + consumersave.getId()
				+ " and Business ID :" + businesssave.getId() + " . Thank you!!");
	}

	@Override
	public Long calBusinessValue(Long businessturnover, Long capitalinvested) {
		if (businessturnover == 0 || capitalinvested == 0 || (businessturnover == capitalinvested)) {
			throw new NullPointerException("NullPointerException in CalBusinessValue");
		}
		Double x_ratio = (double) (businessturnover / capitalinvested);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) businessturnover;
		Double x_min = (double) capitalinvested;
		Double range_diff = (double) (Range_max - Range_min);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		Double businessvalue = (range_diff * sat);
		return (long) Math.abs(Math.round(businessvalue));
	}

	@Override
	public Boolean checkBusinessEligibility(ConsumerBusinessRequest consumerBusinessRequest) throws Exception {
		Boolean check = false;
		businessMaster businessMaster = businessMasterRepository.findByBusinesscategoryAndBusinesstype(
				consumerBusinessRequest.getBusinesscategory(), consumerBusinessRequest.getBusinesstype());
		if (businessMaster == null) {
			return check;
		}
		if (businessMaster.getTotalemployees() <= consumerBusinessRequest.getTotalemployees()
				|| businessMaster.getBusinessage() <= consumerBusinessRequest.getBusinessage()) {
			check = true;
		}
		return check;
	}

	
	@Override
	public Boolean checkPropertyEligibility(String propertytype, String insurancetype, String buildingtype, Long buildingage)throws Exception{
		Boolean check = false;
		propertyMaster propertyMaster = propertyMasterRepository.findByPropertytypeAndInsurancetypeAndBuildingtype(
				propertytype, insurancetype,
				buildingtype);
		if(propertyMaster==null)
		{
			return check;
		}
		if (propertyMaster.getBuildingage() <= buildingage) {
			check = true;
		}
		return check;
	}
	
	
	@Override
	public Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset) {
		if (usefullifeoftheAsset == 0 || salvagevalue == 0 || costoftheasset == 0 || (costoftheasset == salvagevalue)) {
			throw new NullPointerException("NullPointerException in calPropertyValue");
		}
		Double x_ratio = (double) ((costoftheasset - salvagevalue) / usefullifeoftheAsset);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) (costoftheasset / usefullifeoftheAsset);
		Double x_min = (double) (salvagevalue / usefullifeoftheAsset);
		Double range_diff = (Range_max - Range_min);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		Double propertyvalue = range_diff * sat;
		return (long) Math.abs(Math.round(propertyvalue));
	}
	
	
	@Override
	public messageResponse updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails)
			throws BusinessPropertyNotFoundException {
		Optional<consumer> consumer = consumerRepository.findById(consumerBusinessDetails.getConsumerId());
		consumer consumers = consumer.get();

		business business = businessRepository.findByConsumerId(consumerBusinessDetails.getConsumerId());
		consumers.setFirstname(consumerBusinessDetails.getFirstname());
		consumers.setLastname(consumerBusinessDetails.getLastname());
		consumers.setDob(consumerBusinessDetails.getDob());
		consumers.setBusinessname(consumerBusinessDetails.getBusinessname());
		consumers.setPandetails(consumerBusinessDetails.getPandetails());
		consumers.setEmail(consumerBusinessDetails.getEmail());
		consumers.setPhone(consumerBusinessDetails.getPhone());
		consumers.setWebsite(consumerBusinessDetails.getWebsite());
		consumers.setBusinessname(consumerBusinessDetails.getBusinessname());
		consumers.setBusinessoverview(consumerBusinessDetails.getBusinessoverview());
		consumers.setValidity(consumerBusinessDetails.getValidity());
		consumers.setAgentname(consumerBusinessDetails.getAgentname());
		consumers.setAgentid(consumerBusinessDetails.getAgentid());

		consumer consumersave = consumerRepository.save(consumers);
		business.setBusinesscategory(consumerBusinessDetails.getBusinesscategory());
		business.setBusinesstype(consumerBusinessDetails.getBusinesscategory());
		business.setBusinessturnover(consumerBusinessDetails.getBusinessturnover());
		business.setCapitalinvested(consumerBusinessDetails.getCapitalinvested());
		business.setTotalemployees(consumerBusinessDetails.getTotalemployees());
		business.setBusinessvalue(calBusinessValue(business.getBusinessturnover(), business.getCapitalinvested()));
		business.setBusinessage(consumerBusinessDetails.getBusinessage());

		business businesssave = businessRepository.save(business);
		return new messageResponse("Successfully Updated Consumer with Consumer ID: " + consumersave.getId()
				+ "and Business ID: " + businesssave.getId() + " . Thank you!");
	}
	
	
	@Override
	public ConsumerBusinessDetails viewConsumerBusiness(Long consumerid) throws ConsumerBusinessNotFoundException {
		Optional<consumer> consumer = Optional.ofNullable(
				consumerRepository.findById(consumerid).orElseThrow(() -> new ConsumerBusinessNotFoundException()));
		consumer consumers = consumer.get();
		business business = businessRepository.findByConsumerId(consumerid);
		ConsumerBusinessDetails consumerBusinessDetails = new ConsumerBusinessDetails(consumers.getFirstname(),
				consumers.getLastname(), consumers.getDob(), consumers.getBusinessname(), consumers.getPandetails(),
				consumers.getEmail(), consumers.getPhone(), consumers.getWebsite(), consumers.getBusinessoverview(),
				consumers.getValidity(), consumers.getAgentname(), consumers.getAgentid(), business.getId(),
				business.getConsumerId(), business.getBusinesscategory(), business.getBusinesstype(),
				business.getBusinessturnover(), business.getCapitalinvested(), business.getTotalemployees(),
				business.getBusinessvalue(), business.getBusinessage()

		);
		return consumerBusinessDetails;
	}
	
	@Override
	public messageResponse createBusinessProperty(BusinessPropertyRequest businessPropertyRequest) {
		Long propertyValue = calPropertyValue(businessPropertyRequest.getCostoftheasset(),
				businessPropertyRequest.getSalvagevalue(), businessPropertyRequest.getUsefullifeoftheAsset());
		property property = new property(businessPropertyRequest.getBusinessId(),
				businessPropertyRequest.getConsumerId(), businessPropertyRequest.getInsurancetype(),
				businessPropertyRequest.getPropertytype(), businessPropertyRequest.getBuildingsqft(),
				businessPropertyRequest.getBuildingtype(), businessPropertyRequest.getBuildingstoreys(),
				businessPropertyRequest.getBuildingage(), propertyValue, businessPropertyRequest.getCostoftheasset(),
				businessPropertyRequest.getSalvagevalue(), businessPropertyRequest.getUsefullifeoftheAsset());
		property propertysave = propertyRepository.save(property);
		return new messageResponse(
				"SuccessFully Created Business Property with Property Id: " + propertysave.getId() + " . Thank you!!");
	}
	
	@Override
	public messageResponse updateBusinessProperty(BusinessPropertyDetails businessPropertyDetails) {
		property property = propertyRepository.findByConsumerId(businessPropertyDetails.getConsumerId());
		Long propertyValue = calPropertyValue(businessPropertyDetails.getCostoftheasset(),
				businessPropertyDetails.getSalvagevalue(), businessPropertyDetails.getUsefullifeoftheAsset());
		property.setInsurancetype(businessPropertyDetails.getInsurancetype());
		property.setPropertytype(businessPropertyDetails.getPropertytype());
		property.setBuildingsqft(businessPropertyDetails.getBuildingsqft());
		property.setBuildingtype(businessPropertyDetails.getBuildingtype());
		property.setBuildingstoreys(businessPropertyDetails.getBuildingstoreys());
		property.setBuildingage(businessPropertyDetails.getBuildingage());
		property.setPropertyvalue(propertyValue);
		property.setCostoftheasset(businessPropertyDetails.getCostoftheasset());
		property.setSalvagevalue(businessPropertyDetails.getSalvagevalue());
		property.setUsefullifeoftheAsset(businessPropertyDetails.getUsefullifeoftheAsset());

		property propertysave = propertyRepository.save(property);
		return new messageResponse(
				"SuccessFully Updated Business Property with Property Id :" + propertysave.getId() + " . Thank you!");
	}
	
	@Override
	public property viewConsumerProperty(Long consumerid, Long propertyid) {
		property property = propertyRepository.findByConsumerId(consumerid);
		return property;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}