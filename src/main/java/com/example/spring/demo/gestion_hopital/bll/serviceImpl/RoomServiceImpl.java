package com.example.spring.demo.gestion_hopital.bll.serviceImpl;

import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.PatientService;
import com.example.spring.demo.gestion_hopital.bll.service.RoomService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;
import com.example.spring.demo.gestion_hopital.dal.repository.PatientRepository;
import com.example.spring.demo.gestion_hopital.dal.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Long create(Room room) {

        return roomRepository.save(room).getId();
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Room not found"));
    }

    @Override
    public List<Room> findAll() {
        return List.of();
    }

    @Override
    public void update(Long id, Room room) {

    }

    @Override
    public void delete(Long id) {

    }
}
