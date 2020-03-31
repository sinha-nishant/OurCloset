package com.FinalProject.Our_Closet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan 
public class OurClosetApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurClosetApplication.class, args);
	}

}
