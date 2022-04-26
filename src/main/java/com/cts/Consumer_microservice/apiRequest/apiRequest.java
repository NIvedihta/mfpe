package com.cts.Consumer_microservice.apiRequest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.Consumer_microservice.model.property;
import com.cts.Consumer_microservice.payload.request.BusinessPropertyRequest;
import com.cts.Consumer_microservice.payload.request.ConsumerBusinessRequest;
import com.cts.Consumer_microservice.payload.response.BusinessPropertyDetails;
import com.cts.Consumer_microservice.payload.response.ConsumerBusinessDetails;
import com.cts.Consumer_microservice.payload.response.messageResponse;
import com.cts.Consumer_microservice.service.consumerService;

import lombok.extern.slf4j.Slf4j;

import com.cts.Consumer_microservice.repository.PropertyRepository;
import com.cts.Consumer_microservice.repository.buisnessRepository;
import com.cts.Consumer_microservice.repository.businessMasterRepository;
import com.cts.Consumer_microservice.repository.consumerRepository;

@RestController
@Slf4j
public class apiRequest {
	
	Logger log=LoggerFactory.getLogger(apiRequest.class);
	
	@Autowired
	private consumerService consumerService;

	@Autowired
	private buisnessRepository businessRepository;

	@Autowired
	private consumerRepository consumerRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private LoadBalancerClient loadBalencarClient;

	ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

	private RestTemplate restTemplate = new RestTemplate(requestFactory);

	private String getBaseUrl() {
		ServiceInstance instance = loadBalencarClient.choose("POLICY_MICROSERVICE");
		System.out.println(instance.getUri().toString());
		return instance.getUri().toString();
	}

	@GetMapping("/policyService")
	public String callpolicy() {
		try {
			System.out.println("inside try");
//			return new ResponseEntity<String>(restTemplate.getForObject(getBaseUrl() + "/welcome", String.class),HttpStatus.OK);
			return restTemplate.getForObject(getBaseUrl() + "/welcome", String.class);
		} catch (Exception e) {
			System.out.println("inside catch");
			return restTemplate.getForObject(getBaseUrl() + "/welcome", String.class);
//			return "Instance Did Not Match";
		}
	}

	@GetMapping(value="/",produces = { "application/json",})
	public String wish() {
		log.info("this is logger test");
		log.warn("You are testing API CAll");
		log.debug("This is debug test");
		return "Welcome To Consumer MicroService ...";
	}
	
	@PostMapping("/test")
	public String test(@RequestBody String rbody) {
		return rbody;
	}
	

	@PostMapping(value = "/createConsumerBusiness",produces = { "application/json",})
	public messageResponse createConsumerBusiness(@Valid @RequestBody ConsumerBusinessRequest consumerBusinessRequest)
			throws Exception {
		log.info("call For createConsumerBusiness");
		System.out.println(consumerBusinessRequest.toString());
		if (!consumerService.checkBusinessEligibility(consumerBusinessRequest)) {
			System.out.println(consumerBusinessRequest.toString());
			return (new messageResponse("Sorry!!, You are Not Eligibile for Insurance"));
		}
		messageResponse messageResponse = consumerService.createConsumerBusiness(consumerBusinessRequest);
		log.debug("ConsumerBusiness Status: {}", messageResponse);
		log.info("Call End createConsumerBusiness");
		return (messageResponse);
	}
	
	@PostMapping(value="/updateConsumerBusiness",produces = { "application/json",})
	public messageResponse updateConsumerBusiness(@Valid @RequestBody ConsumerBusinessDetails consumerBusinessDetails) {
		log.info("Call For updateConsumerBusiness");
		if (!consumerRepository.existsById(consumerBusinessDetails.getConsumerId())) {
			return (new messageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(consumerBusinessDetails.getConsumerId())) {
			return (new messageResponse("Sorry!!, No Business Found!!"));
		}
		if (!businessRepository.existsById(consumerBusinessDetails.getBusinessid())) {
			return (new messageResponse("Sorry!!, No Business Found!!"));
		}
		messageResponse messageResponse = consumerService.updateConsumerBusiness(consumerBusinessDetails);
		log.debug("ConsumerBusiness Status: {}", messageResponse);
		log.info("Call End updateConsumerBusiness");
		return (messageResponse);
	}


	@GetMapping(value="/viewConsumerBusiness",produces = { "application/json",})
	public ResponseEntity<?> viewConsumerBusiness(@Valid @RequestParam Long consumerid) {
		log.info("call For viewConsumerBusiness");
		if (!consumerRepository.existsById(consumerid)) {
			return ResponseEntity.badRequest().body(new messageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(consumerid)) {
			return ResponseEntity.badRequest().body(new messageResponse("Sorry!!, No Business Found!!"));
		}
		ConsumerBusinessDetails consumerBusinessDetails = consumerService.viewConsumerBusiness(consumerid);
		log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
		log.info("Call End viewConsumerBusiness");
		return ResponseEntity.ok(consumerBusinessDetails);
	}

	
	@GetMapping(value = "/viewConsumerBusinessByPolicy",produces = { "application/json",})
	public ConsumerBusinessDetails viewConsumerBusinessbypolicy(@Valid @RequestParam Long consumerid) {
		log.info("Call For viewConsumerBusinessByPolicy");
		ConsumerBusinessDetails consumerBusinessDetails = consumerService.viewConsumerBusiness(consumerid);
		log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
		log.info("Call End viewConsumerBusinessByPolicy");
		return consumerBusinessDetails;
	}

	@PostMapping(value="/createBusinessProperty",produces = { "application/json",})
	public messageResponse createBusinessProperty(@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest) throws Exception {
		log.info("Call Ends createBusinessProperty");
		if (!consumerRepository.existsById(businessPropertyRequest.getConsumerId())) {
			return (new messageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(businessPropertyRequest.getConsumerId())) {
			return (new messageResponse("Sorry!!, No Business Found!here!"));
		}
		if (!businessRepository.existsById(businessPropertyRequest.getBusinessId())) {
			return (new messageResponse("Sorry!!, No Business Found!!"));
		}
		if (!consumerService.checkPropertyEligibility(businessPropertyRequest.getPropertytype(),
				businessPropertyRequest.getInsurancetype(), businessPropertyRequest.getBuildingtype(),businessPropertyRequest.getBuildingage())) {			
			return (new messageResponse("Sorry!!, You are Not Eligibile for Insurance"));
		}
		messageResponse messageResponse = consumerService.createBusinessProperty(businessPropertyRequest);
		log.debug("BusinessProperty Status: {}", messageResponse);
		log.info("Call End createBusinessProperty");
		return (messageResponse);
		
	}

	@PostMapping(value="/updateBusinessProperty",produces = { "application/json",})
	public messageResponse updateBusinessProperty(@Valid @RequestBody BusinessPropertyDetails businessPropertyDetails) {
		log.info("Call For updateBusinessProperty");
		if (!propertyRepository.existsById(businessPropertyDetails.getPropertyId())) {
			log.info(businessPropertyDetails.toString());
			return (new messageResponse("Sorry!!, No Property Found!!"));
		}
		if (!consumerRepository.existsById(businessPropertyDetails.getConsumerId())) {
			return (new messageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(businessPropertyDetails.getConsumerId())) {
			return (new messageResponse("Sorry!!, No Business Found!!"));
		}
		if (!businessRepository.existsById(businessPropertyDetails.getBusinessId())) {
			return (new messageResponse("Sorry!!, No Business Found!!"));
		}
		messageResponse messageResponse = consumerService.updateBusinessProperty(businessPropertyDetails);
		log.debug("BusinessProperty Status: {}", messageResponse);
		log.info("Call End updateBusinessProperty");
		return (messageResponse);
	}

	@GetMapping(value="/viewConsumerProperty",produces = { "application/json",})
	public ResponseEntity<?> viewConsumerProperty(@Valid @RequestParam Long consumerid, @RequestParam Long propertyid) {
		log.info("Call For viewConsumerProperty");
		if (!propertyRepository.existsById(propertyid)) {
			return ResponseEntity.badRequest().body(new messageResponse("Sorry!!, No Property Found!!"));
		}
		if (!consumerRepository.existsById(consumerid)) {
			return ResponseEntity.badRequest().body(new messageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(consumerid)) {
			return ResponseEntity.badRequest().body(new messageResponse("Sorry!!, No Business Found!!"));
		}
		property property = consumerService.viewConsumerProperty(consumerid, propertyid);
		log.debug("BusinessProperty Details: {}", property.toString());
		log.info("Call End viewConsumerProperty");
		return ResponseEntity.ok(property);
	}

	public messageResponse sendPropertyErrorResponse() {
		return (new messageResponse("(Property Error Response!!"));

	}

	public messageResponse sendConsumerErrorResponse() {
		return (new messageResponse("(Consumer Error Response!!"));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
