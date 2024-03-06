package com.mdk.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//http://localhost:8083
//http://localhost:8083/swagger-ui/index.html
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title="Loan Microservice ",
				description = "Loan microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Raja Penumaka",
						email = "arvindrulzster@gmail.com"
				)
		)
)
@EnableDiscoveryClient
@SpringBootApplication
public class LoanServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoanServiceApplication.class, args);
	}

}
