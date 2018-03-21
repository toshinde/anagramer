package com.moj.anagrammer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnagrammerApplication {
	
	Logger logger = LoggerFactory.getLogger(AnagrammerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AnagrammerApplication.class, args);
	}

}
