package com.ceiba.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableJdbcRepositories
@EnableAutoConfiguration
@EnableResourceServer
public class TodoListApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApp.class, args);
	}
}
