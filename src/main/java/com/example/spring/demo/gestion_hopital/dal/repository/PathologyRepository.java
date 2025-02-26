package com.example.spring.demo.gestion_hopital.dal.repository;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Pathology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PathologyRepository extends JpaRepository<Pathology, Long> {

}
