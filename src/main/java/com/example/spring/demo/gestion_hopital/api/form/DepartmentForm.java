package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Department;

public record DepartmentForm (
        String name
) {
    public static Department toEntity(DepartmentForm form) {
        return new Department(form.name);
    }
}
