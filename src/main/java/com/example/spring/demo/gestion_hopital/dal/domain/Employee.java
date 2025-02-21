package com.example.spring.demo.gestion_hopital.dal.domain;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee extends BaseEntity {

    @Column
    private String name;

    @Column
    private String firstName;

    @Column
    private String email;

    @Column
    private String role;
}
