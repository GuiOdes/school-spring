package com.school.management.system.ExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Properties.Field> fieldList = new ArrayList<>();

        ex.getBindingResult().getAllErrors()
                .forEach(objectError -> {
                    String name = ((FieldError) objectError).getField();
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
                    fieldList.add(new Properties.Field(name, message));
                });

        Properties properties = new Properties(status.toString(), fieldList);

        return handleExceptionInternal(ex, properties, headers, status, request);
    }
}
