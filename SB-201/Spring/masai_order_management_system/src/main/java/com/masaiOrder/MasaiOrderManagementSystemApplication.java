package com.masaiOrder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "REST API", version = "1.1"),
		security = {
				@SecurityRequirement(name = "basicAuth"),
				@SecurityRequirement(name = "bearerToken"),
		},
		servers = {
				@Server(url = "/", description = "Default Server URL")
		})
@SecuritySchemes({
		@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic"),
		@SecurityScheme(name = "bearerToken", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
})
public class MasaiOrderManagementSystemApplication {
	// https://magical-drug-bf2.notion.site/Masai-Order-Management-System-f00debfcd0cb4f1b89d86854199eb45d
	public static void main(String[] args) {
		SpringApplication.run(MasaiOrderManagementSystemApplication.class, args);
	}

}
