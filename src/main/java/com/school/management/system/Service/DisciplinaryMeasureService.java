package com.school.management.system.Service;

import com.school.management.system.Repository.DisciplinaryMeasureRepository;
import com.school.management.system.model.DTO.DisciplinaryMeasureDTO;
import com.school.management.system.model.DisciplinaryMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaryMeasureService {

    @Autowired
    DisciplinaryMeasureRepository repository;

    @Autowired
    EmailService emailService;

    public List<DisciplinaryMeasureDTO> listAll() {
        List<DisciplinaryMeasureDTO> disciplinaryMeasureDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(disciplinaryMeasure -> disciplinaryMeasureDTOList.add(disciplinaryMeasure.toDto()));

        return disciplinaryMeasureDTOList;
    }

    public ResponseEntity<DisciplinaryMeasureDTO> findBy(Long id) {
        return repository.findById(id)
                .map(disciplinaryMeasure -> ResponseEntity.ok(disciplinaryMeasure.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<DisciplinaryMeasureDTO> create(DisciplinaryMeasure disciplinaryMeasure) {
        emailService.newDisciplinaryMeasure(disciplinaryMeasure);
        return new ResponseEntity<>(repository.save(disciplinaryMeasure).toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<DisciplinaryMeasureDTO> update(DisciplinaryMeasure disciplinaryMeasure) {
        return repository.findById(disciplinaryMeasure.getId())
                .map(oldDisciplinaryMeasure -> {
                    oldDisciplinaryMeasure.setStudent(disciplinaryMeasure.getStudent());
                    oldDisciplinaryMeasure.setTeacher(disciplinaryMeasure.getTeacher());
                    oldDisciplinaryMeasure.setGravity(disciplinaryMeasure.getGravity());
                    oldDisciplinaryMeasure.setComment(disciplinaryMeasure.getComment());

                    return new ResponseEntity<>(repository.save(oldDisciplinaryMeasure).toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deleteBy(Long id) {
        return repository.findById(id)
                .map(disciplinaryMeasure -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
