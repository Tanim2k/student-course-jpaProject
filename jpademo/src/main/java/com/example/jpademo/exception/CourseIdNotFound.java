package com.example.jpademo.exception;

public class CourseIdNotFound extends RuntimeException{

    public CourseIdNotFound(String message) {
        super(message);
    }
}
