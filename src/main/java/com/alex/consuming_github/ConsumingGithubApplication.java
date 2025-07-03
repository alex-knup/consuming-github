package com.alex.consuming_github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumingGithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingGithubApplication.class, args);
	}

}
