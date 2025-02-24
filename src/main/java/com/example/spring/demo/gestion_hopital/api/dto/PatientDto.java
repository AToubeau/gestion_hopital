package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;

import java.util.Date;

public record PatientDto(
        Long id,
        String name,
        String firstName,
        Date birtday,
        RoomDto roomDto
) {
    public static PatientDto fromEntity(Patient patient){
        return new PatientDto(patient.getId(), patient.getName(), patient.getFirstName(), patient.getBirthdate(),RoomDto.fromEntity(patient.getRoom()));
    }
}
