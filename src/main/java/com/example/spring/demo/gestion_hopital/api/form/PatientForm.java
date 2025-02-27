package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PatientForm(
        @NotBlank(message = "Le nom est obligatoire!")
        String name,

        @NotBlank(message = "Le prenom est obligatoire!")
        String firstName,

        @NotNull(message = "L'année est obligatoire!")
        Date birthdate,

        @NotNull(message = "L'id de la chambre  est obligatoire!")
        Long room_id
) {
    public Patient toEntity(Room room){
        return new Patient(name, firstName, birthdate, room);
    }
}
