package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TrelloMapperTest {


    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void testMapToBoards() {
        // Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "name", false));
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "AA", trelloListDtos));
        // When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        // Then
        assertEquals("1", trelloBoards.get(0).getId());
        assertEquals("AA", trelloBoards.get(0).getName());
        assertEquals(1, trelloBoards.get(0).getLists().size());
    }

    @Test
    void testMapToBoardsDto() {
        // Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "name1", false));
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "name2", trelloLists));
        // When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);
        // Then
        assertEquals("1", trelloBoardDtos.get(0).getId());
        assertEquals("name2", trelloBoardDtos.get(0).getName());
        assertEquals(1, trelloBoardDtos.get(0).getLists().size());
    }

  /*@Test
    void testMapToList() {
        // Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("2","BB",false));
        //List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        //trelloBoardDtos.add(new TrelloList("2","BBB",false));
        // When
        List<TrelloList> trelloLists1 = trelloMapper.mapToList(trelloListDtos);
        // Then
        assertEquals("2",trelloLists1.get(0).getId());
        assertEquals("BB",trelloLists1.get(0).getName());
        assertEquals(false, trelloLists1.get(0).isClosed());
    }


   */
    @Test
    void testMapToListDto() {
        // Given
        // When
        // Then
    }

    @Test
    void testMapToCardDto() {
        // Given
        // When
        // Then
    }

    @Test
    void testMapToCard() {
        // Given
        // When
        // Then
    }
}