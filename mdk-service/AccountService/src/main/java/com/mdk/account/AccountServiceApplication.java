package com.mdk.account;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//http://localhost:8085/h2-console/l
//http://localhost:8085
//http://localhost:8085/swagger-ui/index.html
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title="Customer Accounts Microservice ",
				description = "EazyBank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Raja Penumaka",
						email = "arvindrulzster@gmail.com"
				)
		)
)
@EnableDiscoveryClient
public class AccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountServiceApplication.class, args);
	}

}
