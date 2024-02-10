package com.hopital.hopline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.hopital.hopline")
public class HoplineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoplineApplication.class, args);
	}

}
