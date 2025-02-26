package com.example.spring.demo.gestion_hopital.bll.service.impl;

import com.example.spring.demo.gestion_hopital.bll.exception.alreadyExists.AlreadyExistException;
import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.DepartmentService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Department;
import com.example.spring.demo.gestion_hopital.dal.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department create(Department department) {
        if (departmentRepository.existsById(department.getId())) {
            throw new AlreadyExistException("Department already exists");
        }
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findbyId(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> findall() {
        return departmentRepository.findAll();
    }

    @Override
    public Department update(Long id, Department department) {
        Department departmentToUpdate = departmentRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Department to update not found"));
        departmentToUpdate.setName(department.getName());

        return departmentRepository.save(departmentToUpdate);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
