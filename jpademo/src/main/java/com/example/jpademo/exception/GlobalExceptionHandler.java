package com.example.jpademo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CourseIdNotFound.class) //It used in specific Exception
    public ResponseEntity<ExceptionDetails> handleResourceNotFoundException(CourseIdNotFound courseIdNotFound,
                                                                            WebRequest webRequest)
    {
        ExceptionDetails exceptionDetails=new ExceptionDetails(
                LocalDateTime.now(),
                courseIdNotFound.getMessage(),
                webRequest.getDescription(false),
                "Course Id is Invalid"
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentIdNotFound.class) //It used in specific Exception
    public ResponseEntity<ExceptionDetails> handleResourceNotFoundException(StudentIdNotFound studentIdNotFound,
                                                                            WebRequest webRequest)
    {
        ExceptionDetails exceptionDetails=new ExceptionDetails(
                LocalDateTime.now(),
                studentIdNotFound.getMessage(),
                webRequest.getDescription(false),
                "Student Id is Invalid"
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
}
