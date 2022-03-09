package com.school.management.system.Service;

import com.school.management.system.Repository.TeacherRepository;
import com.school.management.system.model.DTO.TeacherDTO;
import com.school.management.system.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    int pageSize = 3;

    @Cacheable(value = "teacherList") // saves on cache
    public List<TeacherDTO> listAll(int page) {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page-1, this.pageSize);
        repository.findAll(pageable)
                .forEach(teacher -> teacherDTOList.add(teacher.toDto()));
        return teacherDTOList;
    }

    public ResponseEntity<TeacherDTO> findBy(Long id) {
        return repository.findById(id)
                .map(teacher -> ResponseEntity.ok(teacher.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    @CacheEvict(value = "teacherList", allEntries = true) // clean teacherList cache
    public ResponseEntity<TeacherDTO> create(Teacher teacher) {
        return new ResponseEntity<>(repository.save(teacher).toDtoCreate(), HttpStatus.CREATED);
    }

    @CacheEvict(value = "teacherList", allEntries = true)
    public ResponseEntity<TeacherDTO> update(Teacher teacher) {
        return repository.findById(teacher.getId())
                .map(oldTeacher -> {
                    oldTeacher.setName(teacher.getName());
                    oldTeacher.setBirth(teacher.getBirth());
                    oldTeacher.setEmail(teacher.getEmail());
                    oldTeacher.setStatus(teacher.getStatus());

                    repository.save(oldTeacher);

                    return new ResponseEntity<>(oldTeacher.toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @CacheEvict(value = "teacherList", allEntries = true)
    public ResponseEntity deleteBy(Long id) {
        return repository.findById(id)
                .map(teacher -> {
                    repository.delete(teacher);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
