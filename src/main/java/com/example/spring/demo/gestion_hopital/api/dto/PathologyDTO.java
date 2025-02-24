package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Pathology;

public record PathologyDTO(
        String name,
        String description
) {
    public static PathologyDTO fromEntity(Pathology pathology){
        return new PathologyDTO(pathology.getName(), pathology.getDescription());
    }
}
