package com.ims.internship_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableJpaAuditing
@SpringBootApplication
@EnableWebSecurity
@EnableScheduling
public class InternshipManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipManagementSystemApplication.class, args);
	}

}
 