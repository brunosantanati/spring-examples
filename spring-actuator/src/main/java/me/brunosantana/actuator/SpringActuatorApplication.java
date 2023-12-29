package me.brunosantana.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = { "me.bruno.santana" })
public class SpringActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringActuatorApplication.class, args);
	}

}
