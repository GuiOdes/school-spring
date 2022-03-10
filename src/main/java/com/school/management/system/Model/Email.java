package com.school.management.system.Model;

import com.school.management.system.Model.DTO.EmailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "email")
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String ownerRef;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String emailFrom;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String emailTo;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String subject;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String text;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private LocalDate sendDateEmail;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private StatusEmail statusEmail;

    public EmailDto toDto() {
        return new EmailDto(this.ownerRef, this.emailFrom, this.emailTo, this.subject, this.text);
    }
}
