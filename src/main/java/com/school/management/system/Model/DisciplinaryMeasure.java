package com.school.management.system.Model;

import com.school.management.system.Model.DTO.DisciplinaryMeasureDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "disciplinary_measure")
public class DisciplinaryMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Teacher teacher;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gravity gravity;

    @Column(nullable = false)
    private String comment;

    public DisciplinaryMeasureDTO toDto() {
        return new DisciplinaryMeasureDTO(this.student, this.teacher, this.gravity, this.comment);
    }
}
