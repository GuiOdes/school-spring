package com.school.management.system.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Properties {

    private String status;
    private List<Field> fieldList = new ArrayList<>();

    @AllArgsConstructor
    @Getter
    public static class Field {
        String field;
        String message;
    }
}
