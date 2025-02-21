package com.example.spring.demo.gestion_hopital.dal.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
public class Nurse extends Employee{

    @Column
    private String level;

}
