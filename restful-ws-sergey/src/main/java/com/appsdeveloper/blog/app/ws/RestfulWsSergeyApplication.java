package com.appsdeveloper.blog.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWsSergeyApplication {

	public static void main(String[] args) {
		System.out.println("El ID de este proceso es: " + ProcessHandle.current().pid());
		SpringApplication.run(RestfulWsSergeyApplication.class, args);
	}

}
