package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.AppointmentDto;
import com.example.spring.demo.gestion_hopital.api.form.AppointmentForm;
import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.AppointmentService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return ResponseEntity.ok(
                appointmentService.getAllAppointments()
                        .stream()
                        .map(AppointmentDto::fromEntity)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                AppointmentDto.fromEntity(
                        appointmentService.getAppointmentById(id)
                                .orElseThrow(() -> new RessourceNotFoundException("Appointment not found"))
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id, @RequestBody AppointmentForm appointmentForm) {
        return ResponseEntity.ok(
                AppointmentDto.fromEntity(
                        appointmentService.updateAppointment(id, AppointmentForm.toEntity(appointmentForm))
                )
        );
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentForm appointmentForm) {
        return ResponseEntity.ok(
                AppointmentDto.fromEntity(
                        appointmentService.createAppointment(appointmentForm.startDateTime())
                )
        );
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
