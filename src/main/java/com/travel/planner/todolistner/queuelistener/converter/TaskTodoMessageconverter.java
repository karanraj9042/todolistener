package com.travel.planner.todolistner.queuelistener.converter;


import com.travel.planner.todolistner.domain.TaskTodo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TaskTodoMessageconverter implements Converter<TaskTodoMessageProducer, TaskTodo> {

    @Override
    public TaskTodo convert(TaskTodoMessageProducer taskTodoVO) {
        TaskTodo taskTodo = new TaskTodo();
        if (!StringUtils.isEmpty(taskTodoVO.getTaskId())) {
            taskTodo.setTaskId(taskTodoVO.getTaskId());
        }
        taskTodo.setCompleted(taskTodoVO.getCompleted());
        taskTodo.setTitle(taskTodoVO.getTitle());
        return taskTodo;
    }
}
