package com.example.spring.demo.gestion_hopital.dal.domain.entity;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseEntity<Long> {
    private String name;
}
