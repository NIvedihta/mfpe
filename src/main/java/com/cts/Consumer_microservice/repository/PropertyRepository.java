package com.cts.Consumer_microservice.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.Consumer_microservice.model.property;

@Repository
@Transactional
@DynamicUpdate
public interface PropertyRepository extends JpaRepository<property, Long> {

	property findByConsumerId(Long consumerid);

	boolean existsById(Long propertyId);

}
