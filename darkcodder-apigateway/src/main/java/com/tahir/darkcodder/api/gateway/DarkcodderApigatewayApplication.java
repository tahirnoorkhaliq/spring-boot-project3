package com.tahir.darkcodder.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DarkcodderApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarkcodderApigatewayApplication.class, args);
	}

}
