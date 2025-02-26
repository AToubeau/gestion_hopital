package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Department;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;

public record DepartmentDTO(
        Long id,
        String name
) {
    public static DepartmentDTO fromEntity(Department department) {
        return new DepartmentDTO(department.getId(), department.getName());
    }
}
