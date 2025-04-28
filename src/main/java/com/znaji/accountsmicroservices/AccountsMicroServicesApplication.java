package com.znaji.accountsmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "myAuditorAware")
public class AccountsMicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsMicroServicesApplication.class, args);
    }

}
