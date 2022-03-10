package com.school.management.system.Model;

import com.school.management.system.Model.DTO.GradeDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "grade")
    private List<Student> studentList;

    @OneToMany(mappedBy = "grade")
    private List<Matter> matterList;

    public GradeDTO toDto(Grade this) {
        return new GradeDTO(this);
    }
}
