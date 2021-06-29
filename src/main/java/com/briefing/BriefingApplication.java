package com.briefing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan(basePackages = "com.briefing.entities")
@EnableFeignClients
public class BriefingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriefingApplication.class, args);
	}

}
