package com.cg.fms.feedbackmanagementapp;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.cg.fms")
@EntityScan(basePackages = "com.cg.fms.entities")
@EnableJpaRepositories(basePackages = "com.cg.fms.dao")
@ComponentScan(basePackages = "com.cg.fms")
public class FeedbackManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackManagementAppApplication.class, args);
	}
	
	@Bean
	public Docket openApiFmsStore() {
		return new Docket(DocumentationType.OAS_30)
				.groupName("open-api-fms-store")
				.select()
				.paths(fmsPaths())
				.build();
	}

	private Predicate<String> fmsPaths() {
		return regex(".*/api/.*");
	}

}