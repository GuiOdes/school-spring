package com.school.management.system.Service;

import com.school.management.system.Repository.EvaluationRepository;
import com.school.management.system.model.DTO.EvaluationDTO;
import com.school.management.system.model.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    EvaluationRepository repository;

    public List<EvaluationDTO> listAll() {
        List<EvaluationDTO> evaluationDTOList = new ArrayList<>();
        repository.findAll()
                .forEach(evaluation -> evaluationDTOList.add(evaluation.toDto()));
        return evaluationDTOList;
    }

    public ResponseEntity<EvaluationDTO> findBy(Long id) {
        return repository.findById(id)
                .map(evaluation -> ResponseEntity.ok(evaluation.toDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<EvaluationDTO> create(Evaluation evaluation) {
        repository.save(evaluation);
        return new ResponseEntity<>(evaluation.toDto(), HttpStatus.CREATED);
    }

    public ResponseEntity<EvaluationDTO> update(Evaluation evaluation) {
        return repository.findById(evaluation.getId())
                .map(oldEvaluation -> {
                    oldEvaluation.setResult(evaluation.getResult());
                    oldEvaluation.setMatter(evaluation.getMatter());
                    oldEvaluation.setStudent(evaluation.getStudent());
                    oldEvaluation.setComment(evaluation.getComment());

                    repository.save(oldEvaluation);

                    return new ResponseEntity<>(oldEvaluation.toDto(), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deleteBy(Long id) {
        return repository.findById(id)
                .map(evaluation -> {
                    repository.delete(evaluation);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
