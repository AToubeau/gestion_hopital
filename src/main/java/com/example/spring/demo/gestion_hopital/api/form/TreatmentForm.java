package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Treatment;

public record TreatmentForm(
        String name,
        String description
        //Personnel personnel
) {
    public Treatment toEntity(){
        Treatment treatment = new Treatment();
        treatment.setName(name);
        treatment.setDescription(description);
        //treatment.setPersonnel(personnel);
        return  treatment;
    }
}
