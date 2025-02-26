package com.example.spring.demo.gestion_hopital.api.controller;

import com.example.spring.demo.gestion_hopital.api.dto.PatientDto;
import com.example.spring.demo.gestion_hopital.api.dto.RoomDto;
import com.example.spring.demo.gestion_hopital.api.form.PatientForm;
import com.example.spring.demo.gestion_hopital.api.form.RoomForm;
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
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/createroom")
    public ResponseEntity<Void> create(@RequestBody @Valid RoomForm form){
        roomService.create(form.toEntity());
        return ResponseEntity.ok().build(); // HTTP CODE 200 OK
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RoomDto>> getAll(){
        return ResponseEntity.ok(
                roomService.findAll().stream()
                        .map(RoomDto::fromEntity)
                        .toList()
        );
    }



}
