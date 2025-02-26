package com.example.spring.demo.gestion_hopital.dal.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Secretary extends Employee {
    @Column
    private String office;
}
