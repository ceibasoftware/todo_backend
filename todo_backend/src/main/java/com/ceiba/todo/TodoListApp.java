package com.ceiba.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.ContextConfiguration;

import com.ceiba.todo.config.JdbcConfig;
import com.ceiba.todo.persistence.dao.TaskDao;

@SpringBootApplication
@EnableJdbcRepositories
@ContextConfiguration(classes = JdbcConfig.class)
public class TodoListApp {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApp.class, args);
	}
		

}
