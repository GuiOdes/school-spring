package com.school.management.system.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.school.management.system.Model.DTO.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private LocalDate birth;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "teacher")
    private List<Matter> matterList;

    @OneToMany(mappedBy = "teacher")
    private List<DisciplinaryMeasure> disciplinaryMeasureList;

    public TeacherDTO toDto() {
        return new TeacherDTO(this.name, this.email, this.birth, this.matterList);
    }

    public TeacherDTO toDtoCreate() {
        return new TeacherDTO(this.name, this.email, this.birth);
    }
}
