package com.school.management.system.Service;

import com.school.management.system.Repository.StudentRepository;
import com.school.management.system.model.DTO.StudentDTO;
import com.school.management.system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    EmailService emailService;

    int pageSize = 3;

    public List<StudentDTO> listAll(int page) {
        List<StudentDTO> studentList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, this.pageSize);

        repository.findAll(pageable)
                .forEach(student -> studentList.add(student.toDto()));
        return studentList;
    }

    public ResponseEntity<StudentDTO> findBy(Long id) {
        return repository.findById(id)
                .map(student -> ResponseEntity.ok(student.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<StudentDTO> create(Student student) {
        emailService.newStudentEmail(student);
        return new ResponseEntity<>(repository.save(student).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<Student> update(Student student) {
        return repository.findById(student.getId())
                .map(oldStudent -> {
                    oldStudent.setName(student.getName());
                    oldStudent.setEmail(student.getEmail());
                    oldStudent.setBirth(student.getBirth());
                    oldStudent.setStatus(student.getStatus());
                    oldStudent.setClassroom(student.getClassroom());
                    oldStudent.setGrade(student.getGrade());

                    return new ResponseEntity<>(repository.save(oldStudent), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deleteBy(Long id) {
        return repository.findById(id)
                .map(student -> {
                    repository.delete(student);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
