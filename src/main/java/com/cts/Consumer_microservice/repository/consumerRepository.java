package com.cts.Consumer_microservice.repository;

import java.util.Optional;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.Consumer_microservice.model.consumer;


@Repository
@Transactional
@DynamicUpdate
public interface consumerRepository extends JpaRepository<consumer, Long> {
	Optional<consumer> findById(Long consumerid);
	
	boolean existsById(Long id);
}
