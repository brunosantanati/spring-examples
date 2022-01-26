package me.brunosantana;

import me.brunosantana.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneralExamplesApplication implements CommandLineRunner {

	@Autowired
	MyService service;

	public static void main(String[] args) {
		SpringApplication.run(GeneralExamplesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//https://www.baeldung.com/running-setup-logic-on-startup-in-spring
		System.out.println(service.getGeneratedName());
	}
}
