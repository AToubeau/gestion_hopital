package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.EmployeeDTO;
import com.example.spring.demo.gestion_hopital.api.form.EmployeeForm;
import com.example.spring.demo.gestion_hopital.bll.service.EmployeeService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Employee;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employe")
@RequiredArgsConstructor

public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Long>create(@RequestBody @Valid EmployeeForm form) {
        return ResponseEntity.ok(employeeService.create(form.toEntity()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(EmployeeDTO.fromEntity(employeeService.findById(id)));
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>>getAll(){
        return ResponseEntity.ok(
                employeeService.findAll().stream()
                        .map(EmployeeDTO::fromEntity)
                        .toList()

        );
    }


    @GetMapping
    public List<Employee> findByRole(String role) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}