package com.school.management.system.Service;

import com.school.management.system.Repository.EmailRepository;
import com.school.management.system.model.*;
import com.school.management.system.model.DTO.EmailDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailService {

    @Autowired
    EmailRepository repository;

    @Autowired
    JavaMailSender emailSender;

    private String schoolName = "Colégio Raio de Sol";
    private String schoolEmail = "guilherme.montnezes@gmail.com";

    public void newStudentEmail(Student student) {
        String subject = "Boas vindas ao Raio de Sol, " + student.getName() + "!";
        String text = "Você está alocado para a sala de aula " + student.getClassroom().getName() +
                ". Da " + student.getGrade().getName() + " série!";

        this.sending(
                new EmailDto(
                        this.schoolName,
                        this.schoolEmail,
                        student.getEmail(),
                        subject,
                        text
                )
        );
    }

    public void newDisciplinaryMeasure(DisciplinaryMeasure disciplinaryMeasure) {
        Student student = disciplinaryMeasure.getStudent();
        Teacher teacher = disciplinaryMeasure.getTeacher();
        String subject = "Nova medida disciplinar em seu nome, " + student.getName() + "!";
        String text = "O professor " + teacher.getName() + " solicitou uma medida disciplinar de nível " +
                disciplinaryMeasure.getGravity() + " com as seguintes informações: \n\n" + disciplinaryMeasure.getComment()
                + " Para recorrer a essa medida, por favor, solicite uma ressalva se dirigindo à coordenação ou entrando em contato com o professor.";

        this.sending(
                new EmailDto(
                        this.schoolName,
                        this.schoolEmail,
                        student.getEmail(),
                        subject,
                        text
                )
        );
    }

    public ResponseEntity<EmailDto> sending(EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        email.setSendDateEmail(LocalDate.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return ResponseEntity.ok(repository.save(email).toDto());
        }

    }
}
