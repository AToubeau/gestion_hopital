package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Appointment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService {
    Appointment createAppointment(LocalDateTime startDateTime);
    Optional<Appointment> getAppointmentById(Long id);
   Appointment updateAppointment(Long id, Appointment appointment);
    void deleteAppointment(Long id);
    List<Appointment> getAllAppointments();
}
