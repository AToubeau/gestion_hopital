package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.TreatmentDTO;
import com.example.spring.demo.gestion_hopital.api.form.TreatmentForm;
import com.example.spring.demo.gestion_hopital.bll.service.TreatmentService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Treatment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/treatment")
public class TreatmentController {
    private final TreatmentService treatmentService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody TreatmentForm treatmentForm){
        Treatment treatment = treatmentForm.toEntity();
        return ResponseEntity.ok(treatmentService.create(treatment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(TreatmentDTO.fromEntity(treatmentService.findbyId(id)));
    }

    @GetMapping
    public ResponseEntity<List<TreatmentDTO>> getAll(){
        return ResponseEntity.ok(treatmentService.findall().stream().map(TreatmentDTO::fromEntity).toList());
    }

    /*@GetMapping("/personnel/{personnelId}")
    public ResponseEntity<List<TreatmentDTO>> prescribedByList(@PathVariable Long personnelId){

    }*/

    /*@PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TreatmentForm treatmentForm){
        Treatment updateTreatment = treatmentForm.toEntity(treatmentForm.personnel());
        treatmentService.update(id, updateTreatment);
        return ResponseEntity.noContent().build();
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        treatmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
