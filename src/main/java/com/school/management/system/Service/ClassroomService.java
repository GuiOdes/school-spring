package com.school.management.system.Service;

import com.school.management.system.Repository.ClassroomRepository;
import com.school.management.system.Model.Classroom;
import com.school.management.system.Model.DTO.ClassroomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository repository;

    public List<ClassroomDTO> listAll() {
        List<ClassroomDTO> classroomList = new ArrayList<>();
        repository.findAll()
                .forEach(classroom -> classroomList.add(classroom.toDto()));
        return classroomList;
    }

    public ResponseEntity<ClassroomDTO> findBy(Long id) {
        return repository.findById(id)
                .map(classroom -> ResponseEntity.ok(classroom.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Classroom> create(Classroom classroom) {
        return new ResponseEntity<>(repository.save(classroom), HttpStatus.CREATED);
    }

    public ResponseEntity<Classroom> update(Classroom classroom) {
        return repository.findById(classroom.getId())
                .map(oldClassroom -> {
                    oldClassroom.setName(classroom.getName());
                    oldClassroom.setShift(classroom.getShift());

                    return new ResponseEntity<>(repository.save(oldClassroom), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deleteBy(Long id) {
        return repository.findById(id)
                .map(classroom -> {
                    repository.delete(classroom);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
