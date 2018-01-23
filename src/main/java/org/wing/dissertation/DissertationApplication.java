package org.wing.dissertation;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.wing.dissertation.dao","org.wing.dissertation.service","org.wing.dissertation.controller","org.wing.dissertation.config"})
/*
@MapperScan(basePackages = {"org.wing.dissertation.dao"})
*/
public class DissertationApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DissertationApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DissertationApplication.class, args);
	}
}
