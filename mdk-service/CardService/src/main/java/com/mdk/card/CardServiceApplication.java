package com.mdk.card;

import com.mdk.card.utils.CardNumberGenerator;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title="Card Microservice ",
				description = "Card microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Raja Penumaka",
						email = "arvindrulzster@gmail.com"
				)
		)
)
@EnableDiscoveryClient
public class CardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardServiceApplication.class, args);

		System.out.println(CardNumberGenerator.generate());
	}

}
