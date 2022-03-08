package com.school.management.system.Controller;

import com.school.management.system.Service.DisciplinaryMeasureService;
import com.school.management.system.model.DTO.DisciplinaryMeasureDTO;
import com.school.management.system.model.DisciplinaryMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinary-measures")
public class DisciplinaryMeasureController {

    @Autowired
    DisciplinaryMeasureService service;

    @GetMapping
    public List<DisciplinaryMeasureDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaryMeasureDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping("/new")
    public ResponseEntity<DisciplinaryMeasureDTO> create(@RequestBody DisciplinaryMeasure disciplinaryMeasure) {
        return service.create(disciplinaryMeasure);
    }

    @PutMapping("/update")
    public ResponseEntity<DisciplinaryMeasureDTO> update(@RequestBody DisciplinaryMeasure disciplinaryMeasure) {
        return service.update(disciplinaryMeasure);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }

}
