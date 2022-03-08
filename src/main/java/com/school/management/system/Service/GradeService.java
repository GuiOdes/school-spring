package com.school.management.system.Service;

import com.school.management.system.Repository.GradeRepository;
import com.school.management.system.model.Grade;
import com.school.management.system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {

    @Autowired
    GradeRepository repository;

    public List<Grade> listAll() {
        List<Grade> studentList = new ArrayList<>();
        repository.findAll().forEach(studentList::add);
        return studentList;
    }

    public ResponseEntity<Grade> findBy(Long id) {
        return repository.findById(id)
                .map(grade -> ResponseEntity.ok(grade))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Grade> create(Grade grade) {
        return new ResponseEntity<>(repository.save(grade), HttpStatus.CREATED);
    }

    public ResponseEntity<Grade> update(Grade grade) {
        return repository.findById(grade.getId())
                .map(oldGrade -> {
                    oldGrade.setName(grade.getName());

                    return new ResponseEntity<>(repository.save(oldGrade), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deleteBy(Long id) {
        return repository.findById(id)
                .map(grade -> {
                    repository.delete(grade);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
