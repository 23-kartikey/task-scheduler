package com.karti.task_scheduler.exception;

public class TaskNotFoundException extends RuntimeException{
    
    public TaskNotFoundException(){
        super("Task not found");
    }

    public TaskNotFoundException(Long id){
        super("Task with id "+id+" not found");
    }

    public TaskNotFoundException(String msg){
        throw new RuntimeException("Task not found: "+msg);
    }

}
