package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Appointment;

import java.time.LocalDateTime;

public record AppointmentDto (
        Long id,
        LocalDateTime startDateTime,
        String status
) {
    public static AppointmentDto fromEntity(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getStartDateTime(),
                appointment.getStatus().toString()
        );
    }
}
