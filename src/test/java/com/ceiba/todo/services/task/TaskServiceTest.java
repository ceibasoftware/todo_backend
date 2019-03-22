package com.ceiba.todo.services.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.todo.persistence.entity.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

	@Autowired
	private TaskService taskService;
	
	@InjectMocks
	private Task task;
	
	@Test
	public void loadTodoListTest() {
		List<Task> listDto = taskService.tasksByListId(1);
		
		assertNotNull(listDto.get(0));
		assertEquals("Test task Fix", listDto.get(0).getTitle());
		
	}
}
