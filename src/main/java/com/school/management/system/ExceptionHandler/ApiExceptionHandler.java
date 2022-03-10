package com.school.management.system.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Properties.Field> fieldList = new ArrayList<>();

        ex.getBindingResult().getAllErrors()
                .forEach(objectError -> {
                    String name = ((FieldError) objectError).getField();
                    String message = objectError.getDefaultMessage();
                    fieldList.add(new Properties.Field(name, message));
                });

        Properties properties = new Properties(status.toString(), fieldList);

        return handleExceptionInternal(ex, properties, headers, status, request);
    }
}
