package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Treatment;

import java.util.List;
import java.util.Optional;

public interface TreatmentService {
    Long create(Treatment treatment);
    Treatment findbyId(Long id);
    List<Treatment> findall();
    Optional<Treatment> PrescribedByList(Long personnelId);
    void delete(Long id);
    void update(Long id, Treatment treatment);
}
