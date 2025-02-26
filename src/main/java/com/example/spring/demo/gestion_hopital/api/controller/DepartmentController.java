package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.DepartmentDTO;
import com.example.spring.demo.gestion_hopital.api.form.DepartmentForm;
import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(
                departmentService.findall()
                        .stream()
                        .map(DepartmentDTO::fromEntity)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                DepartmentDTO.fromEntity(
                        departmentService.findbyId(id)
                                .orElseThrow(() -> new RessourceNotFoundException("Department not found"))
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentForm departmentForm) {
        return ResponseEntity.ok(
                DepartmentDTO.fromEntity(
                        departmentService.update(id, DepartmentForm.toEntity(departmentForm))
                )
        );
    }

    @PostMapping("/create")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentForm departmentForm) {
        return ResponseEntity.ok(
                DepartmentDTO.fromEntity(
                        departmentService.create(DepartmentForm.toEntity(departmentForm))
                )
        );
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
