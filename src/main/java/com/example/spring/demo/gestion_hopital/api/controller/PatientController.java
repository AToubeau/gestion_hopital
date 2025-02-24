package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.PatientDto;
import com.example.spring.demo.gestion_hopital.api.form.PatientForm;
import com.example.spring.demo.gestion_hopital.bll.service.PatientService;
import com.example.spring.demo.gestion_hopital.bll.service.RoomService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final RoomService roomService;


    @PostMapping("/createpatient")
    public ResponseEntity<PatientDto> create(@RequestBody @Valid PatientForm form){
        Room room = roomService.findById(form.room_id());
        Patient patient = form.toEntity(room);
        patientService.create(patient);
        return ResponseEntity.ok(PatientDto.fromEntity(patient));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<PatientDto>> getAll(){
        return ResponseEntity.ok(
                patientService.findAll().stream()
                        .map(PatientDto::fromEntity)
                        .toList()
        );
    }
}
