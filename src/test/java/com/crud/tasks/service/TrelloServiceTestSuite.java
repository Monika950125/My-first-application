package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrelloServiceTestSuite {

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void fetchTrelloBoardsTest() {
        //Given
        TrelloService service = new TrelloService(trelloClient,emailService, adminConfig);
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("1", "name", false));
        boardDtos.add(new TrelloBoardDto("1", "name", listDtos));

        when(trelloClient.getTrelloBoards()).thenReturn(boardDtos);

        //When
        List<TrelloBoardDto> resultList = service.fetchTrelloBoards();

        //Then
        Assertions.assertEquals(1, resultList.size());
    }


    @Test
    public void createTrelloCardTest(){
        //Given
        TrelloService service = new TrelloService(trelloClient,emailService, adminConfig);
        TrelloCardDto cardDto = new TrelloCardDto("name", "description", "pos", "list Id");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("id", "name", "URL");

        when(trelloClient.createNewCard(cardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto result = service.createTrelloCard(cardDto);

        //Then
        Assertions.assertEquals(createdTrelloCardDto, result);
    }

}
