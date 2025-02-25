package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Employee;

public record EmployeeDTO(
    Long id,
    String name,
    String firstname,
    String email,
    String role
    ) {
    public static EmployeeDTO fromEntity(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getFirstName(),
                employee.getEmail(),
                employee.getRole(),

        );
    }
}
