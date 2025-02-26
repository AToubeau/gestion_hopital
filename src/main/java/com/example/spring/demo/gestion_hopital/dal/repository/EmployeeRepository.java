package com.example.spring.demo.gestion_hopital.dal.repository;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Employee;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    @Query("SELECT u FROM Employee u WHERE LOWER(u.role) = LOWER(:role) ")
    List<Employee> findByRole(@Param("role") Role role);
}
