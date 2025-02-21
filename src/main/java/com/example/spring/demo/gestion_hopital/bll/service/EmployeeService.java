package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.api.form.EmployeeForm;
import com.example.spring.demo.gestion_hopital.dal.domain.Employee;
import com.example.spring.demo.gestion_hopital.dal.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface EmployeeService {

    Long create(Employee employee);
    Employee findById(Long id);
    List<Employee> findall();
    void delete(Long id);
    void update(Long id, Employee employee);
    List<Employee> findByRole(String role);/* @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid EmployeeForm form) {
    }

    public List<Employee> findByRole(String role) {
        return EmployeeRepository.findByRole(role);*/
}
