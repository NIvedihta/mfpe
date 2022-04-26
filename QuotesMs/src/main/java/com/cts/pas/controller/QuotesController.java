package com.cts.pas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pas.model.Quotes;
import com.cts.pas.repo.QuotesRepository;
/**
 * 
 * @author vishnu mandati
 *
 */
@RestController
public class QuotesController {
	
		@Autowired
		QuotesRepository quotesRepo;
		/**
		 * 
		 * @param businessValue 
		 * @param propertyValue
		 * @param propertyType
		 * @return
		 */
		@GetMapping("/getQuotesForPolicy")
		public String getQuotesForPolicy( @RequestBody Quotes quotes){

		//String result;
		try
		        {
		Quotes quoteValue=quotesRepo.findByBusinessValueAndPropertyTypeAndPropertyValue(quotes.getBusinessValue(), quotes.getPropertyType(), quotes.getPropertyValue());
		//result=quoteValue.getQuotes();
		if(quoteValue!=null)
		{
			System.out.println("Inside try block");
			return quoteValue.getQuotesInInr();
		}
		//System.out.println("Inside quotes policy");
		 
		        }
		catch(Exception e)
		        {
		       // result= "No Quotes, Contact Insurance Provider";
		        System.out.println(e.getMessage());
		        System.out.println("Inside catch block");
		        
		        }
		return "No Quotes, Contact Insurance Provider";
		}


		}



