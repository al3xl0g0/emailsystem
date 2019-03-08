package com.example.emailsys.emailsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmailsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailsysApplication.class, args);
	}

}
