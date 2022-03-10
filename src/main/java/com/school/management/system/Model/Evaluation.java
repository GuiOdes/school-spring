package com.school.management.system.Model;

import com.school.management.system.Model.DTO.EvaluationDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private double result;

    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(nullable = false)
    private Matter matter;

    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @Column
    private String comment;

    public EvaluationDTO toDto() {
        return new EvaluationDTO(this.result, this.matter.getName(), this.student.getName(), this.comment);
    }
}
