package com.school.management.system.Controller;

import com.school.management.system.Service.TeacherService;
import com.school.management.system.model.DTO.TeacherDTO;
import com.school.management.system.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService service;

    @GetMapping
    public List<TeacherDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping("/new")
    public ResponseEntity<TeacherDTO> create(@RequestBody Teacher teacher) {
        return service.create(teacher);
    }

    @PutMapping("/update")
    public ResponseEntity<TeacherDTO> update(@RequestBody Teacher teacher) {
        return service.update(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }
}
