package com.school.management.system.Model;

import com.school.management.system.Model.DTO.StudentDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private LocalDate birth;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    @NotNull
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
