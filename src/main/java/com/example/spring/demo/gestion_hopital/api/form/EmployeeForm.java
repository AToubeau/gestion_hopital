package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import javax.swing.text.html.parser.Entity;

public record EmployeeForm(

        @NotBlank(message = "L'id de l'employé est obligatoire")
        Long id,

        @NotBlank(message = "Le nom est obligatoire")
        String name,

        @NotBlank(message = "Le prénom est obligatoire")
        String firstname,

        @NotBlank(message = "L'email est obligatoire pour le joindre")
        String email,

        @NotEmpty(message = "Le rôle du personnel doit absolument être spécifié")
        String role
) {
        public Employee toEntity(){
                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setFirstName(firstname);
                employee.setEmail(email);
                employee.setRole(role);
                return employee;


        }
}
