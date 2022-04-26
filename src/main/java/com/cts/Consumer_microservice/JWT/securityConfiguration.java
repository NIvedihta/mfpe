package com.cts.Consumer_microservice.JWT;

import org.apache.commons.logging.Log;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class securityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO configure authentication manager
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// TODO configure web security
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers("/**").permitAll();
		// .and()

	}

}