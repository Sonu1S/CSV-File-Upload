package net.javaguide.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCsvFileApplication {
           //project URL//localhost:8081/files/upload
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCsvFileApplication.class, args);

		System.out.println("CSV File Upload");
	}

}
