package com.durys.jakub.companymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CompanyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyManagementApplication.class, args);
	}

}
