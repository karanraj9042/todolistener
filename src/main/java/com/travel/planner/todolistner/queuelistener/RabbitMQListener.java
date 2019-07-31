package com.travel.planner.todolistner.queuelistener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.planner.todolistner.domain.TaskTodo;
import com.travel.planner.todolistner.queuelistener.converter.TaskTodoMessageProducer;
import com.travel.planner.todolistner.queuelistener.converter.TaskTodoMessageconverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@EnableBinding(RabbitChannelListener.class)
public class RabbitMQListener {

    @Autowired
    private TaskTodoMessageconverter taskTodoMessageconverter;

    private ObjectMapper objectMapper = new ObjectMapper();



    @StreamListener(target = RabbitChannelListener.GREETING)
    public void recievedMessage(String messageMap) {
        System.out.println("Recieved Message From queue: " + messageMap);
        try {
            TaskTodoMessageProducer t = objectMapper.readValue(messageMap, TaskTodoMessageProducer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<TaskTodo> todoList = new ArrayList<>();

    }
}
