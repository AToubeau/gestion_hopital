package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.PathologyDTO;
import com.example.spring.demo.gestion_hopital.api.form.PathologyForm;
import com.example.spring.demo.gestion_hopital.bll.service.PathologyService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Pathology;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pathology")
public class PathologyController {
    private final PathologyService pathologyService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody PathologyForm pathologyForm){
        Pathology pathology = pathologyForm.toEntity();
        return ResponseEntity.ok(pathologyService.create(pathology));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PathologyDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(PathologyDTO.fromEntity(pathologyService.findbyId(id)));
    }

    @GetMapping
    public ResponseEntity<List<PathologyDTO>> getAll(){
        return ResponseEntity.ok(pathologyService.findall().stream().map(PathologyDTO::fromEntity).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PathologyForm pathologyForm){
        Pathology pathology = pathologyForm.toEntity();
        pathologyService.update(id,pathology);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pathologyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
