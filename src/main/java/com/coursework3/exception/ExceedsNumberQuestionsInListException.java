package com.coursework3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExceedsNumberQuestionsInListException extends RuntimeException{
    public ExceedsNumberQuestionsInListException(String message) {
        super(message);
    }
}