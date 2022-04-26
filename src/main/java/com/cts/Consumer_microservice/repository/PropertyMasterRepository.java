package com.cts.Consumer_microservice.repository;

import org.hibernate.annotations.DynamicUpdate;

import com.cts.Consumer_microservice.model.propertyMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@DynamicUpdate
public interface PropertyMasterRepository extends JpaRepository<propertyMaster, Long> {

	propertyMaster findByPropertytypeAndInsurancetypeAndBuildingtype(String propertytype, String insurancetype,
			String buildingtype);

}
