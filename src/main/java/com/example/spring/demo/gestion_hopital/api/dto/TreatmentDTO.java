package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Treatment;

public record TreatmentDTO(
        String name,
        String description,
        Personnel personnel
) {
    public static TreatmentDTO fromEntity(Treatment treatment){
        return new TreatmentDTO(treatment.getName(), treatment.getDescription(), treatment.getPersonnel());
    }
}
