package com.example.spring.demo.gestion_hopital.dal.domain.entity;

import jakarta.persistence.Column;

public class Secretary extends Employee {
    @Column
    private String office;
}
