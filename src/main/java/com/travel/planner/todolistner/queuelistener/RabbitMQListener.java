package com.travel.planner.todolistner.queuelistener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.planner.todolistner.domain.TaskTodo;
import com.travel.planner.todolistner.queuelistener.converter.TaskTodoMessageProducer;
import com.travel.planner.todolistner.queuelistener.converter.TaskTodoMessageconverter;
import com.travel.planner.todolistner.service.TaskTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableBinding(RabbitChannelListener.class)
public class RabbitMQListener {

    @Autowired
    private TaskTodoMessageconverter taskTodoMessageconverter;

    @Autowired
    private TaskTodoService taskTodoService;

    private ObjectMapper objectMapper = new ObjectMapper();



    @StreamListener(target = RabbitChannelListener.GREETING)
    public void recievedMessage(String messageMap) {
        System.out.println("Recieved Message From queue: " + messageMap);
        List<TaskTodoMessageProducer> todoList = new ArrayList<>();
        try {
            TaskTodoMessageProducer[] taksVo = objectMapper.readValue(messageMap, TaskTodoMessageProducer[].class);
             todoList = Arrays.asList(taksVo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<TaskTodo> taskTodos = new ArrayList<>();
        for (TaskTodoMessageProducer taskTodoMessageProducer : todoList) {
             taskTodos.add(taskTodoMessageconverter.convert(taskTodoMessageProducer));
        }
        taskTodoService.saveListOfTodos(taskTodos);
    }
}
