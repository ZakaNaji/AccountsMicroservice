package com.znaji.accountsmicroservices.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservice Docs",
                description = "This is a detailed docs of the deferent api end points of our Accounts MS",
                contact = @Contact(
                        name = "Zakaria Naji",
                        email = "znaji@gmail.com",
                        url = "www.znaji.com"
                ),
                license = @License(
                        name = "Appach 2.0",
                        url = "www.znaji.com"
                ),
                version = "V1.0"
        )
)
public class OpenApiConfig {
}
