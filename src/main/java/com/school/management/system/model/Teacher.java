package com.school.management.system.model;

import com.school.management.system.model.DTO.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "teacher")
    private List<Matter> matterList;

    @OneToMany(mappedBy = "teacher")
    private List<DisciplinaryMeasure> disciplinaryMeasureList;

    public TeacherDTO toDto() {
        return new TeacherDTO(this.name, this.email, this.birth, this.matterList);
    }

    public TeacherDTO toDtoCreate() {
        return new TeacherDTO(this.name, this.email, this.birth);
    }
}
