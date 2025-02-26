package com.example.spring.demo.gestion_hopital.bll.serviceImpl;

import com.example.spring.demo.gestion_hopital.api.form.RoomForm;
import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.PatientService;
import com.example.spring.demo.gestion_hopital.bll.service.RoomService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Department;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;
import com.example.spring.demo.gestion_hopital.dal.repository.DepartmentRepository;
import com.example.spring.demo.gestion_hopital.dal.repository.PatientRepository;
import com.example.spring.demo.gestion_hopital.dal.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Room create(RoomForm roomForm) {
        Department department = departmentRepository.findById(roomForm.departmentId()).orElseThrow(() -> new RessourceNotFoundException("le departement"));
        Room room = RoomForm.toEntity(roomForm, department);

        return roomRepository.save(room);
    }

    @Override
    public Room findById(Long id) {
        return null;
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
