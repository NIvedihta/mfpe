package com.cts.pas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.sun.istack.NotNull;

@Entity
	public class Quotes  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int qid;

	@NotNull
	private int businessValue;

	@NotNull
	private int propertyValue;

	
	private String propertyType;

	
	@Column(name = "QuotesInInr")
	private String quotesInInr;

	public int getBusinessValue()
	{
	return businessValue;
	}

	public void setBusinessValue(int businessValue)
	{
	this.businessValue=businessValue;
	}

	public int getPropertyValue()
	{
	return propertyValue;
	}

	public void setPropertyValue(int propertyValue)
	{
	this.propertyValue=propertyValue;
	}

	public String getPropertyType()
	{
	return propertyType;
	}

	public void setPropertyType(String propertyType)
	{
	this.propertyType=propertyType;
	}


	public String getQuotesInInr()
	{

	return quotesInInr;
	}

	public void setQuotesInInr(String quotesInInr)
	{
	this.quotesInInr=quotesInInr;
	}

	public Quotes(int qid,int businessValue,int propertyValue,String propertyType,String quotesInInr)
	{
	this.qid=qid;
	this.businessValue=businessValue;
	this.propertyValue=propertyValue;
	this.propertyType=propertyType;
	this.quotesInInr=quotesInInr;
	}


	public Quotes()
	{

	}

	}


