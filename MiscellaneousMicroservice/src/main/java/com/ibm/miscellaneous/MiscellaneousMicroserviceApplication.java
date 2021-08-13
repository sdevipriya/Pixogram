package com.ibm.miscellaneous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MiscellaneousMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscellaneousMicroserviceApplication.class, args);
	}

}
