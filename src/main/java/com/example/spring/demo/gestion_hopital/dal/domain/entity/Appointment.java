package com.example.spring.demo.gestion_hopital.dal.domain.entity;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.base.BaseEntity;
import com.example.spring.demo.gestion_hopital.dal.domain.enum_.AppointmentStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseEntity<Long> {
    private LocalDateTime startDateTime;
    private AppointmentStatus status;

    public Appointment(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
        this.status = AppointmentStatus.REGISTERED;
    }
}
