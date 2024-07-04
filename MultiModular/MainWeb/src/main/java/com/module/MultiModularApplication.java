package com.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.module.*"})
@EntityScan(basePackages = {"com.module.*"})
@EnableJpaRepositories(basePackages = {"com.module.*"})
@EnableFeignClients(basePackages = {"com.module.*"})
public class MultiModularApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModularApplication.class, args);
	}

}
