package com.dexlock.SpringRestMongoDBDemo;
import com.dexlock.SpringRestMongoDBDemo.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class SpringRestMongoDbDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestMongoDbDemoApplication.class, args);
	}
}
