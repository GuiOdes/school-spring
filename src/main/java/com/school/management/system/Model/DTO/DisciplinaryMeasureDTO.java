package com.school.management.system.Model.DTO;

import com.school.management.system.Model.Gravity;
import com.school.management.system.Model.Student;
import com.school.management.system.Model.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaryMeasureDTO {

    private String studentName;
    private String teacherName;
    private Gravity gravity;
    private String comment;

    public DisciplinaryMeasureDTO(Student student, Teacher teacher, Gravity gravity, String comment) {
        this.studentName = student.getName();
        this.teacherName = teacher.getName();
        this.gravity = gravity;
        this.comment = comment;
    }
}
