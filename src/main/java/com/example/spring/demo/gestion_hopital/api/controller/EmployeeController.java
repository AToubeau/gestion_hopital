package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.EmployeeDTO;
import com.example.spring.demo.gestion_hopital.api.form.EmployeeForm;
import com.example.spring.demo.gestion_hopital.bll.service.EmployeeService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Employee;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Long>create(@RequestBody @Valid EmployeeForm form) {
        return ResponseEntity.ok(employeeService.create(form));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(EmployeeDTO.fromEntity(employeeService.findById(id)));
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>>getAll(){
        return ResponseEntity.ok(
                employeeService.findAll().stream()
                        .map(EmployeeDTO::fromEntity)
                        .toList()

        );
    }


    @GetMapping("/find-by-role")
    public ResponseEntity<List<Employee>> getEmployeesByRole(@RequestParam Role role) {
        List<Employee> employees = employeeService.findByRole(role);
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employees);
        }
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}