package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;

import java.util.List;

public interface PatientService {
    Long create(Patient patient);
    Patient findById(Long id);
    List<Patient> findAll();
    void update(Long id, Patient patient);
    void delete(Long id);
}
