package com.school.management.system.Controller;

import com.school.management.system.Service.GradeService;
import com.school.management.system.model.Grade;
import com.school.management.system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService service;

    @GetMapping
    public List<Grade> listAll() {
        return service.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Grade> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<Grade> create(@RequestBody Grade grade) {
        return service.create(grade);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Grade> update(@RequestBody Grade grade) {
        return service.update(grade);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }
}
