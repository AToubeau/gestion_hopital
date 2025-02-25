package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Appointment;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AppointmentForm(
        @DateTimeFormat
        @NotNull
        LocalDateTime startDateTime
) {
    public static Appointment toEntity(AppointmentForm appointmentForm) {
        return new Appointment(appointmentForm.startDateTime);
    }
}
