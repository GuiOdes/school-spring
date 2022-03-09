package com.school.management.system.Controller;

import com.school.management.system.Service.GradeService;
import com.school.management.system.model.DTO.GradeDTO;
import com.school.management.system.model.Grade;
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
    public List<GradeDTO> listAll() {
        return service.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GradeDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<GradeDTO> create(@RequestBody Grade grade) {
        return service.create(grade);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<GradeDTO> update(@RequestBody Grade grade) {
        return service.update(grade);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }
}
