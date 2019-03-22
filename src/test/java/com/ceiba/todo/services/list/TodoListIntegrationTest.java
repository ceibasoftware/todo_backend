package com.ceiba.todo.services.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.todo.persistence.entity.TodoList;
import com.ceiba.todo.persistence.entity.User;
import com.ceiba.todo.services.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoListIntegrationTest {

	@Autowired
	private TodoListService todoListService;
	
	@Autowired
	private UserService UserService;
	
	@InjectMocks
	private TodoList todoList;
	
	@InjectMocks
	private User user;
	
	@Before
	public void setUp() {
		User userCreated = UserService.findUserByUserName("german.arroyave");
		if(userCreated == null) {
			user.setUsername("german.arroyave");
			user.setPassword("test");
			userCreated = UserService.create(user);
		}	
		
		todoList.setName("Home Work");
		todoList.setDescription("Task todo at home");
		todoList.setUserId(userCreated.getUserId());
		
		todoListService.create(todoList);
	}
	
	@Test
	public void updateTest() {
		List<TodoList> listDto = todoListService.listsByUserId(1);
		listDto.get(0).setName("Home Work Fix");
		TodoList todoList2Assert = todoListService.update(listDto.get(0));
		
		assertTrue(todoList2Assert.getName().equals("Home Work Fix"));
		assertEquals(todoList2Assert.getName(), listDto.get(0).getName());
		
	}
	
}
