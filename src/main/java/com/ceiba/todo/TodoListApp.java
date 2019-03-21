package com.ceiba.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
@EnableAutoConfiguration
public class TodoListApp {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApp.class, args);
	}
		

}
