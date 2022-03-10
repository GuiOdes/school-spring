package com.school.management.system.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EvaluationDTO {

    private double result;
    private String matterName;
    private String studentName;
    private String comment;
}
