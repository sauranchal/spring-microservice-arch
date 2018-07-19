package com.pkg.spring.eureka.client.reservationservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class Reservationservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reservationservice3Application.class, args);
	}
}
