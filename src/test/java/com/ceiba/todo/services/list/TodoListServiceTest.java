package com.ceiba.todo.services.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.todo.persistence.entity.TodoList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoListServiceTest {

	@Autowired
	private TodoListService todoListService;
	
	@InjectMocks
	private TodoList todoList;
	
	@Test
	public void loadTodoListTest() {
		List<TodoList> listDto = todoListService.listsByUserId(1);
		
		assertNotNull(listDto.get(0));
		assertEquals("Task todo at home", listDto.get(0).getDescription());
		
	}
}
