package com.school.management.system.Service;

import com.school.management.system.Repository.MatterRepository;
import com.school.management.system.Model.DTO.MatterDTO;
import com.school.management.system.Model.Matter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatterService {

    @Autowired
    MatterRepository repository;

    public List<MatterDTO> listAll() {
        List<MatterDTO> matterList = new ArrayList<>();

        repository.findAll()
                .forEach(matter -> matterList.add(matter.toDto()));

        return matterList;
    }

    public ResponseEntity<MatterDTO> findBy(Long id) {
        return repository.findById(id)
                .map(matter -> ResponseEntity.ok(matter.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    @SneakyThrows
    public ResponseEntity<MatterDTO> create(Matter matter) {
        if (existsByName(matter.getName())) {
            throw new SQLIntegrityConstraintViolationException("Uma matéria com esse nome já existe!");
        }
        repository.save(matter);
        return new ResponseEntity<>(matter.toDto(), HttpStatus.CREATED);
    }

    private boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    public ResponseEntity<MatterDTO> update(Matter matter) {
        return repository.findById(matter.getId())
                .map(oldMatter -> {
                    oldMatter.setName(matter.getName());
                    oldMatter.setWorkload(matter.getWorkload());
                    oldMatter.setTeacher(matter.getTeacher());
                    oldMatter.setGrade(matter.getGrade());

                    repository.save(matter);
                    return new ResponseEntity<>(matter.toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deleteBy(Long id) {
        return repository.findById(id)
                .map(matter -> {
                    repository.delete(matter);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
