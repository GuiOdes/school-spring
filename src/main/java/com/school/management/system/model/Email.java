package com.school.management.system.model;

import com.school.management.system.model.DTO.EmailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(nullable = false)
    private String ownerRef;

    @Column(nullable = false)
    private String emailFrom;

    @Column(nullable = false)
    private String emailTo;

    @Column(nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(nullable = false)
    private LocalDate sendDateEmail;

    @Column(nullable = false)
    private StatusEmail statusEmail;

    public EmailDto toDto() {
        return new EmailDto(this.ownerRef, this.emailFrom, this.emailTo, this.subject, this.text);
    }
}
