package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskMapperTest {

    @Test
    public void mapToTaskTest() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        TaskDto taskDto = new TaskDto(1L, "title", "content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        Assertions.assertEquals(taskDto.getId(), task.getId());
        Assertions.assertEquals(taskDto.getTitle(), task.getTitle());
        Assertions.assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "title", "content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        Assertions.assertEquals(task.getId(), taskDto.getId());
        Assertions.assertEquals(task.getTitle(), taskDto.getTitle());
        Assertions.assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest(){
        //Given
        TaskMapper taskMapper = new TaskMapper();
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L,"title", "content"));

        //When
        List<TaskDto> resultList = taskMapper.mapToTaskDtoList(tasks);

        //Then
        Assertions.assertEquals(1, resultList.size());
        Assertions.assertEquals(tasks.get(0).getId(), resultList.get(0).getId());
    }
}
