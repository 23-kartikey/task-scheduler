package com.karti.task_scheduler.exception;

public class TaskNotFoundException extends RuntimeException{
    
    public TaskNotFoundException(){
        throw new RuntimeException();
    }

    public TaskNotFoundException(Long id){
        throw new RuntimeException("Task with id "+id+" not found");
    }

    public TaskNotFoundException(String msg){
        throw new RuntimeException("Task not found: "+msg);
    }

}
