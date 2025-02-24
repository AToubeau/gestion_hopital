package com.example.spring.demo.gestion_hopital.dal.domain.entity;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
public class Patient extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String firstName;

    @Column(nullable = false)
    private Date birthdate;

    @OneToOne
    @JoinColumn(name = "room_id",nullable = false)
    private Room room;

    public Patient(String name, String firstName, Date birthdate, Room room) {
        this.name = name;
        this.firstName = firstName;
        this.birthdate= birthdate;
        this.room= room;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
