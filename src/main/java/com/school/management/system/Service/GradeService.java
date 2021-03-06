package com.school.management.system.Service;

import com.school.management.system.Repository.GradeRepository;
import com.school.management.system.Model.DTO.GradeDTO;
import com.school.management.system.Model.Grade;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {

    @Autowired
    GradeRepository repository;

    public List<GradeDTO> listAll() {
        List<GradeDTO> gradeList = new ArrayList<>();
        repository.findAll()
                .forEach(grade -> gradeList.add(grade.toDto()));
        return gradeList;
    }

    public ResponseEntity<GradeDTO> findBy(Long id) {
        return repository.findById(id)
                .map(grade -> ResponseEntity.ok(grade.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    @SneakyThrows
    public ResponseEntity<GradeDTO> create(Grade grade) {
        if (existsByName(grade.getName())) {
            throw new SQLIntegrityConstraintViolationException("Essa série já existe!");
        }
        return new ResponseEntity<>(repository.save(grade).toDto(), HttpStatus.CREATED);
    }

    private boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    public ResponseEntity<GradeDTO> update(Grade grade) {
        return repository.findById(grade.getId())
                .map(oldGrade -> {
                    oldGrade.setName(grade.getName());

                    return new ResponseEntity<>(repository.save(oldGrade).toDto(), HttpStatus.CREATED);
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
