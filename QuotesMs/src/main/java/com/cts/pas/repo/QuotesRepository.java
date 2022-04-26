package com.cts.pas.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pas.model.Quotes;

@Repository
@Transactional
public interface QuotesRepository extends JpaRepository<Quotes,Integer>
{
Quotes findByBusinessValueAndPropertyTypeAndPropertyValue(int businessValue,String propertyType,int propertyValue);
}
