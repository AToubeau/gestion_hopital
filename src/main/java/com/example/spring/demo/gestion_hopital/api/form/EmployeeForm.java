package com.example.spring.demo.gestion_hopital.api.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record EmployeeForm(
        @NotBlank(message = "Le nom est obligatoire")
        String name,

        @NotBlank(message = "Le prénom est obligatoire")
        String firstname,

        @NotBlank(message = "L'email est obligatoire pour le joindre")
        String email,

        @NotEmpty(message = "Le rôle du personnel doit absolument être spécifié")
        String role
)
{
}
