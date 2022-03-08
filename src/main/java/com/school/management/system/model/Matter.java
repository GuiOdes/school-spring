package com.school.management.system.model;

import com.school.management.system.model.DTO.MatterDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "matter")
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int workload;

    @ManyToOne
    @JoinColumn(nullable = false, name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "grade", nullable = false)
    private Grade grade;

    @OneToMany(mappedBy = "matter")
    private List<Evaluation> evaluationList;

    public MatterDTO toDto() {
        return new MatterDTO(this.name, this.workload, this.teacher, this.grade);
    }
}
