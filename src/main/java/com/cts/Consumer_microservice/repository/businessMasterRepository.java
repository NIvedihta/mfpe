package com.cts.Consumer_microservice.repository;

import org.hibernate.annotations.DynamicUpdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.Consumer_microservice.model.businessMaster;



@Repository
@Transactional
@DynamicUpdate
public interface businessMasterRepository extends JpaRepository<businessMaster, Long> {

	businessMaster findByBusinesscategoryAndBusinesstype(String businesscategory, String businesstype);

}


