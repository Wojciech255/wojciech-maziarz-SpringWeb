package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
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

    @Test
    void testMapToList() {
        // Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("2", "BB", false));
        // When
        List<TrelloList> trelloLists1 = trelloMapper.mapToList(trelloListDtos);
        // Then
        assertEquals("2", trelloLists1.get(0).getId());
        assertEquals("BB", trelloLists1.get(0).getName());
        assertEquals(false, trelloLists1.get(0).isClosed());
    }

    @Test
    void testMapToListDto() {
        // Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("3", "CC", false));
        // When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        // Then
        assertEquals("3", trelloListDtos.get(0).getId());
        assertEquals("CC", trelloListDtos.get(0).getName());
        assertEquals(false, trelloListDtos.get(0).isClosed());
    }

    @Test
    void testMapToCardDto() {
        // Given
        TrelloCard trelloCard = new TrelloCard("a","b","c","d");
        // When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        // Then
        assertEquals("a",trelloCardDto.getName());
        assertEquals("b",trelloCardDto.getDescription());
        assertEquals("c",trelloCardDto.getPos());
        assertEquals("d",trelloCardDto.getListId());
    }

    @Test
    void testMapToCard() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("aa","bb","cc","dd");
        // When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        // Then
        assertEquals("aa",trelloCard.getName());
        assertEquals("bb",trelloCard.getDescription());
        assertEquals("cc",trelloCard.getPos());
        assertEquals("dd",trelloCard.getListId());
    }
}