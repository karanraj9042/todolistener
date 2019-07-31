package com.travel.planner.todolistner.repository;

import com.travel.planner.todolistner.domain.TaskTodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTodoRepository  extends CrudRepository<TaskTodo,Long> {
}
