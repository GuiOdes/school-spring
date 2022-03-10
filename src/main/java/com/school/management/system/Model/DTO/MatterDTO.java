package com.school.management.system.Model.DTO;

import com.school.management.system.Model.Grade;
import com.school.management.system.Model.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatterDTO {

    private String name;
    private int workload;
    private String teacherName;
    private String gradeName;

    public MatterDTO(String name, int workoad, Teacher teacher, Grade grade) {
        this.name = name;
        this.workload = workoad;
        this.teacherName = teacher.getName();
        this.gradeName = grade.getName();
    }
}
