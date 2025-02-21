package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Appointment;

import java.time.LocalDateTime;

public record AppointmentForm(
        LocalDateTime startDateTime
) {
    public static Appointment toEntity(AppointmentForm appointmentForm) {
        return new Appointment(appointmentForm.startDateTime);
    }
}
