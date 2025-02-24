package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Pathology;

public record PathologyForm(
        String name,
        String description
) {
   public Pathology toEntity(){
        Pathology pathology = new Pathology();
        pathology.setName(name);
        pathology.setDescription(description);
        return  pathology;
    }
}
