package com.school.management.system.Model;

import com.school.management.system.Model.DTO.DisciplinaryMeasureDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "disciplinary_measure")
public class DisciplinaryMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(nullable = false)
    private Teacher teacher;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gravity gravity;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String comment;

    public DisciplinaryMeasureDTO toDto() {
        return new DisciplinaryMeasureDTO(this.student, this.teacher, this.gravity, this.comment);
    }
}
