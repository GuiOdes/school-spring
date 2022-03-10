package com.school.management.system.Model;

import com.school.management.system.Model.DTO.EvaluationDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private double result;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Matter matter;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @Column(nullable = true)
    private String comment;

    public EvaluationDTO toDto() {
        return new EvaluationDTO(this.result, this.matter.getName(), this.student.getName(), this.comment);
    }
}
