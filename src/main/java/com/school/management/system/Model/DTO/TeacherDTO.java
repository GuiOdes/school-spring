package com.school.management.system.Model.DTO;

import com.school.management.system.Model.Matter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TeacherDTO {

    private String name;
    private String email;
    private LocalDate birth;
    private List<MatterDTO> matterList = new ArrayList<>();

    public TeacherDTO(String name, String email, LocalDate birth, List<Matter> matters) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        matters.forEach(matter -> this.matterList.add(matter.toDto()));
    }

    public TeacherDTO(String name, String email, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
}
