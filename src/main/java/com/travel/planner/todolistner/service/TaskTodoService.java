package com.travel.planner.todolistner.service;

import com.travel.planner.todolistner.domain.TaskTodo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskTodoService {
    void saveListOfTodos(List<TaskTodo> todoList);
}
