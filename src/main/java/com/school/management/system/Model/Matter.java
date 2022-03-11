package com.school.management.system.Model;

import com.school.management.system.Model.DTO.MatterDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "matter")
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Min(value = 5)
    @Column(nullable = false)
    private int workload;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "teacher_id")
    private Teacher teacher;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "grade", nullable = false)
    private Grade grade;

    @OneToMany(mappedBy = "matter")
    private List<Evaluation> evaluationList;

    public MatterDTO toDto() {
        return new MatterDTO(this.name, this.workload, this.teacher, this.grade);
    }
}
