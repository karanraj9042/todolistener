package com.travel.planner.todolistner.service.impl;

import com.travel.planner.todolistner.domain.TaskTodo;
import com.travel.planner.todolistner.repository.TaskTodoRepository;
import com.travel.planner.todolistner.service.TaskTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTodoServiceImpl implements TaskTodoService {

    @Autowired
    private TaskTodoRepository taskTodoRepository;


    @Override
    public void saveListOfTodos(List<TaskTodo> todoList) {
        System.out.println("Saving Todos in Database");
            taskTodoRepository.saveAll(todoList);
    }
}
