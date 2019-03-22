package com.ceiba.todo.services.task;

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

import com.ceiba.todo.persistence.entity.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceIntegrationTest {

	@Autowired
	private TaskService taskService;
	
	@InjectMocks
	private Task task;
	
	@Before
	public void setUp() {
		task.setListId(1);
		task.setTitle("Test task");
		
		taskService.create(task);
	}
	
	@Test
	public void updateTest() {
		List<Task> listDto = taskService.tasksByListId(1);
		listDto.get(0).setTitle("Test task Fix");
		Task task2Assert = taskService.update(listDto.get(0));
		
		assertTrue(task2Assert.getTitle().equals("Test task Fix"));
		assertEquals(task2Assert, listDto.get(0));
		
	}
}
