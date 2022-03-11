package com.school.management.system.ExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Properties.Field> fieldList = new ArrayList<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    fieldList.add(new Properties.Field(fieldError.getField(), fieldError.getDefaultMessage()));
                });

        Properties properties = new Properties();

        properties.setStatus(status.toString());
        properties.setTitle("Alguns campos estão inválidos!");
        properties.setFieldList(fieldList);

        return handleExceptionInternal(ex, properties, headers, status, request);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSqlViolation(SQLIntegrityConstraintViolationException exception, WebRequest request) {

        Properties properties = new Properties();

        properties.setStatus(HttpStatus.BAD_REQUEST.toString());
        properties.setTitle(exception.getMessage());

        return handleExceptionInternal(exception, properties, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
