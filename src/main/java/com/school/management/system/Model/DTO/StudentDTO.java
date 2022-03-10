package com.school.management.system.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String name;
    private String email;
    private LocalDate birth;
    private String classroomName;
    private String gradeName;
}
