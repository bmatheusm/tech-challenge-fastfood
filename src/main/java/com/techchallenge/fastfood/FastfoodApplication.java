package com.techchallenge.fastfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class FastfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastfoodApplication.class, args);
	}

}
