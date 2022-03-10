package com.school.management.system.Controller;

import com.school.management.system.Service.MatterService;
import com.school.management.system.Model.DTO.MatterDTO;
import com.school.management.system.Model.Matter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matters")
public class MatterController {

    @Autowired
    MatterService service;

    @GetMapping
    public List<MatterDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatterDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping("/new")
    public ResponseEntity<MatterDTO> create(@RequestBody Matter matter) {
        return service.create(matter);
    }

    @PutMapping("/update")
    public ResponseEntity<MatterDTO> update(@RequestBody Matter matter) {
        return service.update(matter);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }
}
