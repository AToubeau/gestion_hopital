package com.example.spring.demo.gestion_hopital.bll.service.impl;

import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.AppointmentService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Appointment;
import com.example.spring.demo.gestion_hopital.dal.domain.enum_.AppointmentStatus;
import com.example.spring.demo.gestion_hopital.dal.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(LocalDateTime startDateTime) {
        Appointment appointment = new Appointment(startDateTime, AppointmentStatus.REGISTERED);

        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment appointmentToUpdate = getAppointmentById(id).orElseThrow(() -> new RessourceNotFoundException("Appointment not found"));
        appointmentToUpdate.setStartDateTime(appointment.getStartDateTime());
        appointmentToUpdate.setStatus(appointment.getStatus());

        return appointmentRepository.save(appointmentToUpdate);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
