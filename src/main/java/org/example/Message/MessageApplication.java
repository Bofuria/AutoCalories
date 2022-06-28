package org.example.Message;

import org.example.Message.Calories.ListOfFood;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class MessageApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}

}
