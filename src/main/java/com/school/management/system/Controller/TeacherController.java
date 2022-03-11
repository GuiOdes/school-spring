package com.school.management.system.Controller;

import com.school.management.system.Service.TeacherService;
import com.school.management.system.Model.DTO.TeacherDTO;
import com.school.management.system.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService service;

    @GetMapping("/{page}")
    public List<TeacherDTO> listAll(@PathVariable int page) {
        return service.listAll(page);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TeacherDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping("/new")
    public ResponseEntity<TeacherDTO> create(@Valid @RequestBody Teacher teacher) {
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
