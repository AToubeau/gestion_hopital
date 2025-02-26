package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Department;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Pathology;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department create(Department department);
    Optional<Department> findbyId(Long id);
    List<Department> findall();
    Department update(Long id, Department department);
    void delete(Long id);
}
