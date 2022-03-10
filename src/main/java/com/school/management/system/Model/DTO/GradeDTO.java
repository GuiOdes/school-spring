package com.school.management.system.Model.DTO;

import com.school.management.system.Model.Grade;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GradeDTO {
    private String name;
    private List<StudentDTO> studentDTOList = new ArrayList<>();
    private List<MatterDTO> matterDTOList = new ArrayList<>();

    public GradeDTO(Grade grade) {
        this.name = grade.getName();
        grade.getStudentList()
                .forEach(student -> this.studentDTOList.add(student.toDto()));
        grade.getMatterList()
                .forEach(matter -> this.matterDTOList.add(matter.toDto()));
    }
}
