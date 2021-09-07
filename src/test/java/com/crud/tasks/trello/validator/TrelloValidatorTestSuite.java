package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloValidatorTestSuite {

    @Test
    public void validateTrelloBoardTest(){
        //Given
        TrelloValidator validator = new TrelloValidator();
        List<TrelloList> lists = new ArrayList<>();
        List<TrelloBoard> boards = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("Id","name", lists);
        boards.add(trelloBoard);

        //When
        List<TrelloBoard> trelloBoards = validator.validateTrelloBoards(boards);

        //Then
        Assertions.assertEquals(1,trelloBoards.size());
    }

    @Test
    public void validateTrelloBoardWhenListIsEmptyTest(){
        //Given
        TrelloValidator validator = new TrelloValidator();
        List<TrelloBoard> boards = new ArrayList<>();

        //When
        List<TrelloBoard> trelloBoards = validator.validateTrelloBoards(boards);

        //Then
        Assertions.assertTrue(trelloBoards.isEmpty());
    }
}
