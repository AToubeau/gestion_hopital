package com.example.spring.demo.gestion_hopital.dal.repository;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
