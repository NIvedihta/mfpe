package com.cts.pas.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pas.model.ConsumerPolicy;

@Repository
@Transactional
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy,Long>{

	ConsumerPolicy findByConsumerIdAndPolicyId(Long consumerId, String policyId);
	
}
