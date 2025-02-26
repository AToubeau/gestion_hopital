package com.example.spring.demo.gestion_hopital.dal.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@Table
public class Doctor extends Employee {

    @Column
    private String speciality;


}
