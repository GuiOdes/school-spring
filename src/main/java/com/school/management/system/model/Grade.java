package com.school.management.system.model;

import com.school.management.system.model.DTO.GradeDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
