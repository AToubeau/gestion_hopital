package com.example.spring.demo.gestion_hopital.bll.serviceImpl;

import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.EmployeeService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Employee;
import com.example.spring.demo.gestion_hopital.dal.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Long create(Employee employee) {

        return employeeRepository.save(employee).getId();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee not found"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void update(Long id, Employee employee) {
        Employee employeeToUpdate = findById(id);


    }

    @Override
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
    @Override
    public List<Employee> findByRole(String role){
        return employeeRepository.findByRole(role);
    }
}
