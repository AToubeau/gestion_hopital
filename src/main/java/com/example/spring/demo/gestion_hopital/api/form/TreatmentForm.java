package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Treatment;

public record TreatmentForm(
        String name,
        String description,
        Long patientId
        //Personnel personnel
) {
    public Treatment toEntity(Patient patient) {
        Treatment treatment = new Treatment();
        treatment.setName(name);
        treatment.setDescription(description);
        treatment.setPatient(patient);
        //treatment.setPersonnel(personnel);
        return  treatment;
    }
}
