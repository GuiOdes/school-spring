package com.school.management.system.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties {

    private String status;
    private String title;
    private List<Field> fieldList;

    @AllArgsConstructor
    @Getter
    public static class Field {
        String field;
        String message;
    }
}
