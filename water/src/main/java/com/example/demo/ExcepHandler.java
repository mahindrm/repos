package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExcepHandler extends RuntimeException{


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleinvalidargument(MethodArgumentNotValidException ex) {
        Map<String, String> errormap=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errormap.put(error.getField(), error.getDefaultMessage());

        });
        return errormap;

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Usernotfoundexception.class)
    public Map<String,String> handle(Usernotfoundexception exception)
    {
        Map<String, String> errormap=new HashMap<>();
        errormap.put("errorMessage",exception.getMessage());
        return errormap;
    }

}
