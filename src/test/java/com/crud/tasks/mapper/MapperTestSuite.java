package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MapperTestSuite {


    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> lists = new ArrayList<>();
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("id", "name", lists);
        trelloBoardsDto.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        Assertions.assertFalse(trelloBoards.isEmpty());
    }

    @Test
    public void mapToBoardsWhenListIsEmptyTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        Assertions.assertTrue(trelloBoards.isEmpty());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> lists = new ArrayList<>();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("id", "name", lists);
        trelloBoards.add(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        Assertions.assertFalse(trelloBoardsDto.isEmpty());
    }

    @Test
    public void mapToBoardsDtoWhenListIsEmptyTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloBoard> trelloBoards = new ArrayList<>();

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        Assertions.assertTrue(trelloBoardsDto.isEmpty());
    }

    @Test
    public void mapToListTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> listsDto = new ArrayList<>();
        TrelloListDto trelloListDto = new TrelloListDto("id", "name", true);
        listsDto.add(trelloListDto);
        //When
        List<TrelloList> lists = trelloMapper.mapToList(listsDto);

        //Then
        Assertions.assertFalse(lists.isEmpty());
    }

    @Test
    public void mapToListWhenListIsEmptyTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> listsDto = new ArrayList<>();

        //When
        List<TrelloList> lists = trelloMapper.mapToList(listsDto);

        //Then
        Assertions.assertTrue(lists.isEmpty());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> lists = new ArrayList<>();
        TrelloList trelloList = new TrelloList("id", "name", true);
        lists.add(trelloList);
        //When
        List<TrelloListDto> listsDto = trelloMapper.mapToListDto(lists);

        //Then
        Assertions.assertFalse(listsDto.isEmpty());
    }
    @Test
    public void mapToListDtoWhenListIsEmptyTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> lists = new ArrayList<>();

        //When
        List<TrelloListDto> listsDto = trelloMapper.mapToListDto(lists);

        //Then
        Assertions.assertTrue(listsDto.isEmpty());
    }

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
}
