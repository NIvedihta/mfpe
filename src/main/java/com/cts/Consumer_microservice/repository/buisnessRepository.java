package com.cts.Consumer_microservice.repository;



import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.Consumer_microservice.model.business;

@Repository
@Transactional
@DynamicUpdate
public interface buisnessRepository extends JpaRepository<business, Long> {

	business findByConsumerId(Long consumerId);

	boolean existsById(Long id);

	Boolean existsByConsumerId(Long consumerId);

}
