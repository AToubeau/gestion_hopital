package com.example.spring.demo.gestion_hopital.bll.serviceImpl;

import com.example.spring.demo.gestion_hopital.bll.service.PathologyService;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Pathology;
import com.example.spring.demo.gestion_hopital.dal.repository.PathologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PathologyServiceImpl implements PathologyService{
    private final PathologyRepository pathologyRepository;

    @Override
    public Long create(Pathology pathology) {
        return pathologyRepository.save(pathology).getId();
    }

    @Override
    public Pathology findbyId(Long id) {
        return pathologyRepository.findById(id).orElseThrow(() -> new RuntimeException("Pathology doesn't exist"));
    }

    @Override
    public List<Pathology> findall() {
        return pathologyRepository.findAll();
    }

    @Override
    public void update(Long id, Pathology pathology) {
        Pathology upatedPathology = findbyId(id);
        upatedPathology.setName(pathology.getName());
        upatedPathology.setDescription(pathology.getDescription());
        pathologyRepository.save(upatedPathology);
    }

    @Override
    public void delete(Long id) {
        if(pathologyRepository.existsById(id))
            throw new RuntimeException("Pathology not found");
        pathologyRepository.deleteById(id);
    }
}
