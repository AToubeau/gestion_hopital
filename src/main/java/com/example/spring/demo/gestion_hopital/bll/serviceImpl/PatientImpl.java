package com.example.spring.demo.gestion_hopital.bll.serviceImpl;

import com.example.spring.demo.gestion_hopital.bll.service.PatientService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.repository.PatientRepository;
import com.example.spring.demo.gestion_hopital.dal.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientImpl implements PatientService {
    private final PatientRepository patientRepository;

   /* public PatientImpl(PatientRepository patientRepository) {
        this.patientRepository=patientRepository;
    }*/

    @Override
    public Long create(Patient patient) {
        return  patientRepository.save(patient).getId();
    }

    @Override
    public Patient findById(Long id) {
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return  patientRepository.findAll();
    }

    @Override
    public void update(Long id, Patient patient) {
        Patient patientToUpdate = findById(id);
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setFirstName(patient.getFirstName());
        patientToUpdate.setBirthdate(patient.getBirthdate());

    }

    @Override
    public void delete(Long id) {

    }
}
