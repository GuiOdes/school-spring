package com.school.management.system.Controller;

import com.school.management.system.Service.EvaluationService;
import com.school.management.system.Model.DTO.EvaluationDTO;
import com.school.management.system.Model.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService service;

    @GetMapping
    public List<EvaluationDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDTO> findBy(@PathVariable Long id) {
        return service.findBy(id);
    }

    @PostMapping("/new")
    public ResponseEntity<EvaluationDTO> create(@RequestBody Evaluation evaluation) {
        return service.create(evaluation);
    }

    @PutMapping("/update")
    public ResponseEntity<EvaluationDTO> update(@RequestBody Evaluation evaluation) {
        return service.update(evaluation);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return service.deleteBy(id);
    }
}
