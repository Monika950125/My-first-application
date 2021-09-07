package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTest {

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
    public void mapToCardDtoTest(){
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "list id");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assertions.assertEquals(trelloCard.getName(), trelloCardDto.getName());
        Assertions.assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
    }

    @Test
    public void mapToCardTest(){
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "list id");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assertions.assertEquals(trelloCardDto.getName(), trelloCard.getName());
        Assertions.assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
    }
}
