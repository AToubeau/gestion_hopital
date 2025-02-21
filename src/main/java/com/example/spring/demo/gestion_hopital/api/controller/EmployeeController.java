package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.EmployeeDTO;
import com.example.spring.demo.gestion_hopital.bll.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employe")
@RequiredArgsConstructor

public class EmployeeController {

    @PostMapping
    public ResponseEntity<> ()  {
        return ResponseEntity.ok()
}
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(EmployeeDTO.fromEntity(EmployeeService.findById(id)));

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            EmployeeService.delete(id);
            return ResponseEntity.noContent().build();