package com.cw.b5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Boot5MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot5MySqlApplication.class, args);
	}

}
