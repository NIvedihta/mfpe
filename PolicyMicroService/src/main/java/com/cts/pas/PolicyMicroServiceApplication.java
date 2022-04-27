package com.cts.pas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.cts.pas.*")
public class PolicyMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroServiceApplication.class, args);
	}

}
