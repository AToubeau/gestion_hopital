package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Pathology;

import java.util.List;

public interface PathologyService {
    Long create(Pathology pathology);
    Pathology findbyId(Long id);
    List<Pathology> findall();
    void update(Long id, Pathology pathology);
    void delete(Long id);
}
