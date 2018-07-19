package com.pkg.spring.eurekaservice5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaService5Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaService5Application.class, args);
	}
}
