package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DbServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllTasksTest(){
        //Given
        DbService service = new DbService(taskRepository);
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L,"title", "content"));

        when(taskRepository.findAll()).thenReturn(tasks);

        //When
        List<Task> results = service.getAllTasks();

        //Then
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(1L, results.get(0).getId());
    }

    @Test
    public void saveTaskTest(){
        //Given
        DbService service = new DbService(taskRepository);
        Task task = new Task(1L,"title", "content");

        when(taskRepository.save(task)).thenReturn(task);

        //When
        Task result = service.saveTask(task);

        //Then
        Assertions.assertEquals(task.getId(), result.getId());
    }

    @Test
    public void getTaskTest(){
        //Given
        DbService service = new DbService(taskRepository);
        Task task = new Task(1L, "title", "content");
        Long id = task.getId();

        when(taskRepository.findById(id)).thenReturn(java.util.Optional.of(task));

        //When
        Optional<Task> result = service.getTask(id);

        //Then
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void deleteTaskTest(){
        //Given
        DbService service = new DbService(taskRepository);
        Task task = new Task(1L, "title", "content");
        Long id = task.getId();

        //When & Then
        service.deleteTask(id);
        verify(taskRepository, times(1)).deleteById(id);
    }

}
