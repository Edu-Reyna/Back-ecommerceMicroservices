package com.MGoldenPearl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MicroserviceCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommentApplication.class, args);
	}

}
