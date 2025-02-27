package com.example.spring.demo.gestion_hopital.bll.serviceImpl;

import com.example.spring.demo.gestion_hopital.api.form.TreatmentForm;
import com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.spring.demo.gestion_hopital.bll.service.TreatmentService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Treatment;
import com.example.spring.demo.gestion_hopital.dal.repository.PatientRepository;
import com.example.spring.demo.gestion_hopital.dal.repository.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final PatientRepository patientRepository;

    @Override
    public Long create(TreatmentForm treatmentForm) {
        Patient patient = patientRepository.findById(treatmentForm.patientId()).orElseThrow(()-> new RessourceNotFoundException("patient not found"));
        Treatment treatment = treatmentForm.toEntity(patient);

        return treatmentRepository.save(treatment).getId();
    }

    @Override
    public Treatment findbyId(Long id) {
        return treatmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Treatment not found"));
    }

    @Override
    public List<Treatment> findall() {
        return treatmentRepository.findAll();
    }

   /* @Override
    public Optional<Treatment> PrescribedByList(Long personnelId) {
        return treatmentRepository.PrescribedByList(personnelId);
    }*/

    @Override
    public void delete(Long id) {
        if(treatmentRepository.existsById(id))
            throw new RuntimeException("Treatment not found");
        treatmentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Treatment treatment) {
        Treatment updateTreatment = findbyId(id);
        updateTreatment.setName(treatment.getName());
        updateTreatment.setDescription(treatment.getDescription());
        //updateTreatment.setPersonnel(treatment.getPersonnel());
        treatmentRepository.save(updateTreatment);
    }
}
