package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.swing.text.html.parser.Entity;

public record EmployeeForm(

        @NotBlank(message = "Le nom est obligatoire")
        String name,

        @NotBlank(message = "Le prénom est obligatoire")
        String firstname,

        @NotBlank(message = "L'email est obligatoire pour le joindre")
        String email,

        @NotNull(message = "Le rôle du personnel doit absolument être spécifié")
        Role role,
        String speciality,  //Doctor
        String level,       // Nurse
        String office       // Secretary
) {
        public Employee toEntity() {
                return switch (role) {
                        case DOCTOR -> {
                                Doctor doctor = new Doctor();
                                doctor.setName(name);
                                doctor.setFirstName(firstname);
                                doctor.setEmail(email);
                                doctor.setRole(Role.DOCTOR);
                                doctor.setSpeciality(speciality); // Spécifique à Doctor
                                yield doctor;
                        }
                        case NURSE -> {
                                Nurse nurse = new Nurse();
                                nurse.setName(name);
                                nurse.setFirstName(firstname);
                                nurse.setEmail(email);
                                nurse.setRole(Role.NURSE);
                                nurse.setLevel(level); // Spécifique à Nurse
                                yield nurse;
                        }
                        case SECRETARY -> {
                                Secretary secretary = new Secretary();
                                secretary.setName(name);
                                secretary.setFirstName(firstname);
                                secretary.setEmail(email);
                                secretary.setRole(Role.SECRETARY);
                                secretary.setOffice(office); // Spécifique à Secretary
                                yield secretary;
                        }
                };
        }
}
