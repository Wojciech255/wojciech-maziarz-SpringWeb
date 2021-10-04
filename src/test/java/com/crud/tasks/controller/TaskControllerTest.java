package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DbService service;
    @MockBean
    private TaskMapper taskMapper;

    @Test
    void shouldFetchEmptyTask() throws Exception {
        //Given
        when(service.getAllTasks()).thenReturn(List.of());
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/task/getTasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

  /*  @Test
    void getTask() throws Exception {
        //Given
        List<TaskDto> taskDtos = List.of(new TaskDto(1L,"AA","CC"));
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/task/getTask")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }


   */
    @Test
    void deleteTask() {
        //Given
        //When & Then
    }

    @Test
    void updateTask() {
        //Given
        //When & Then
    }

    @Test
    void shouldCreateTask() throws Exception  {
        //Given
        TaskDto taskDto = new TaskDto(1L,"AA","BB");
        //When & Then
        Task task = taskMapper.mapToTask(taskDto);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/task/createTask")
                        .contentType(MediaType.APPLICATION_JSON));
                //.andExpect(service.saveTask(task));
                //.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }
}