package com.school.management.system.Model;

import com.school.management.system.Model.DTO.StudentDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @OneToMany(mappedBy = "student")
    private List<DisciplinaryMeasure> disciplinaryMeasureList;

    @OneToMany(mappedBy = "student")
    private List<Evaluation> evaluationList;

    public StudentDTO toDto() {
        return new StudentDTO(this.name, this.email, this.birth, this.classroom.getName(), this.grade.getName());
    }
}