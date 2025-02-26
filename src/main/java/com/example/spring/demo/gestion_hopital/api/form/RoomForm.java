package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Department;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;
import jakarta.validation.constraints.NotBlank;

public record RoomForm(
        @NotBlank(message = "Le nom de la chambre est obligatoire!")
        String name,
        Long departmentId
) {
    public static Room toEntity(RoomForm roomForm, Department department) {
        return new Room(roomForm.name, department);
    }
}
