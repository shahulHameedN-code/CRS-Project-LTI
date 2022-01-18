package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * 
 * Contains method to greet users by their name and location.
 * 
 */

@ComponentScan({"com.lt.*"})
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class CrsLtiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtiProjectApplication.class, args);
	}

}
