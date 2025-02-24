package com.example.spring.demo.gestion_hopital.dal.domain.entity;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;


    public Room(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
