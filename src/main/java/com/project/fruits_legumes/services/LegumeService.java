package com.project.fruits_legumes.services;

import com.project.fruits_legumes.models.Legume;
import com.project.fruits_legumes.repository.LegumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegumeService {
    @Autowired
    private LegumeRepository legumeRepository;

    public List<Legume> getAllLegumes() {
        return legumeRepository.findAll();
    }

    public Legume addLegume(Legume legume) {
        return legumeRepository.save(legume);
    }

    public Optional<Legume> getLegumeById(Long id) {
        return legumeRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return legumeRepository.existsById(id);
    }

    public void deleteLegumeById(Long id) {
        legumeRepository.deleteById(id);
    }
}
