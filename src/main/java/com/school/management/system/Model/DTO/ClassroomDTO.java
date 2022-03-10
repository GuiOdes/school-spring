package com.school.management.system.Model.DTO;

import com.school.management.system.Model.Shift;
import com.school.management.system.Model.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class ClassroomDTO {

    private String name;
    private Shift shift;
    private List<StudentDTO> studentList;

    public ClassroomDTO(String name, Shift shift, List<Student> students) {
        this.name = name;
        this.shift = shift;
        this.studentList = new ArrayList<>();
        students.forEach(student -> studentList.add(student.toDto()));
    }
}
