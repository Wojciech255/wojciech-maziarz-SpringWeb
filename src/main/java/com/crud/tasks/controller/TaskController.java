package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @GetMapping(value = "getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getTask")
    public TaskDto getTask(@RequestParam Long taskId) {
        return new TaskDto(1L, "test title", "test_content");
    }

    @DeleteMapping(value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId) {

    }

    @PutMapping(value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @PostMapping(value = "createTask")
    public void createTask(@RequestBody TaskDto taskDto) {

    }
}
