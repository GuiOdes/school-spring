package com.school.management.system.Controller;

import com.school.management.system.Service.ClassroomService;
import com.school.management.system.model.Classroom;
import com.school.management.system.model.DTO.ClassroomDTO;
import com.school.management.system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    ClassroomService service;

    @GetMapping
    public List<ClassroomDTO> listAll() {
        return service.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassroomDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<Classroom> create(@RequestBody Classroom classroom) {
        return service.create(classroom);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Classroom> update(@RequestBody Classroom classroom) {
        return service.update(classroom);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }
}
