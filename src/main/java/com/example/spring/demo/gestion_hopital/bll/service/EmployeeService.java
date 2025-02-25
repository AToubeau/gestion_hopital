package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Long create(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void delete(Long id);
    void update(Long id, Employee employee);
    List<Employee> findByRole(String role);
    /* @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid EmployeeForm form) {
    }

    public List<Employee> findByRole(String role) {
        return EmployeeRepository.findByRole(role);*/
}
