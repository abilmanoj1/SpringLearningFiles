package com.dexlock.SpringMongoRestApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.management.Query;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class SpringMongoRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoRestAppApplication.class, args);
	}
}
