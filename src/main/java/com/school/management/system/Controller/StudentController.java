package com.school.management.system.Controller;

import com.school.management.system.Service.StudentService;
import com.school.management.system.model.DTO.StudentDTO;
import com.school.management.system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public List<StudentDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping("/new")
    public ResponseEntity<StudentDTO> create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return service.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }

}
