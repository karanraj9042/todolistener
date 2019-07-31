package com.travel.planner.todolistner.queuelistener.converter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class TaskTodoMessageProducer {
    @JsonProperty
    private Long taskId;
    @JsonProperty
    private String title;
    @JsonProperty
    private Boolean completed = false;


    private Date createdAt;

    private Date updatedAt;


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "TaskTodoMessageProducer{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
