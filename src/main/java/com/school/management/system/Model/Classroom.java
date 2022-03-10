package com.school.management.system.Model;

import com.school.management.system.Model.DTO.ClassroomDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "class")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @NotBlank
    private String name;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Shift shift;

    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

    public ClassroomDTO toDto() {
        return new ClassroomDTO(this.name, this.shift, this.students);
    }
}
