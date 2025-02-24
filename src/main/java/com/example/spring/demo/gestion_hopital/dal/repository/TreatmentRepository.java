package com.example.spring.demo.gestion_hopital.dal.repository;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
   /* @Query( "Select u from Treatment u where u.personnel.id ilike :personnelId")
    Optional<Treatment> PrescribedByList(Long personnelId);*/
}
