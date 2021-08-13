package com.ibm.media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MediaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaMicroserviceApplication.class, args);
	}

}
