package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.*;

public record EmployeeDTO(
    Long id,
    String name,
    String firstname,
    String email,
    Role role,
    String speciality,
    String level,
    String office
    ) {
    public static EmployeeDTO fromEntity(Employee employee) {
        if (employee instanceof Doctor doctor) {
            return new EmployeeDTO(
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getFirstName(),
                    doctor.getEmail(),
                    doctor.getRole(),
                    doctor.getSpeciality(),
                    null,
                    null
            );
        } else if (employee instanceof Nurse nurse) {
            return new EmployeeDTO(
                    nurse.getId(),
                    nurse.getName(),
                    nurse.getFirstName(),
                    nurse.getEmail(),
                    nurse.getRole(),
                    null,
                    nurse.getLevel(),
                    null
            );
        } else if (employee instanceof Secretary secretary) {
            return new EmployeeDTO(
                    secretary.getId(),
                    secretary.getName(),
                    secretary.getFirstName(),
                    secretary.getEmail(),
                    secretary.getRole(),
                    null,
                    null,
                    secretary.getOffice()
            );

        } else {
            return new EmployeeDTO(
                    employee.getId(),
                    employee.getName(),
                    employee.getFirstName(),
                    employee.getEmail(),
                    employee.getRole(),
                    null,
                    null,
                    null
            );
        }

    }
}
