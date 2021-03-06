package com.school.management.system.Controller;

import com.school.management.system.Service.StudentService;
import com.school.management.system.Model.DTO.StudentDTO;
import com.school.management.system.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/{page}")
    public List<StudentDTO> listAll(@PathVariable int page) {
        return service.listAll(page);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<StudentDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping("/new")
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody Student student) {
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
