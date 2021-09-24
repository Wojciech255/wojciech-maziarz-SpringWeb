package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TrelloMapperTest {


    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void testMapToBoards(){
        // Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1","name",false));
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1","AA",trelloListDtos));
        // When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        // Then
        assertEquals("1",trelloBoards.get(0).getId());
        assertEquals("AA",trelloBoards.get(0).getName());
        assertEquals(1,trelloBoards.get(0).getLists().size());
    }

    @Test
    void testMapToBoardsDto(){
        // Given
        // When
        // Then
    }

    @Test
    void testMapToList(){
        // Given
        // When
        // Then
    }

    @Test
    void testMapToListDto(){
        // Given
        // When
        // Then
    }

    @Test
    void testMapToCardDto(){
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