package com.coursework3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionOnListException extends RuntimeException{
    public QuestionOnListException(String message) {
        super(message);
    }
}