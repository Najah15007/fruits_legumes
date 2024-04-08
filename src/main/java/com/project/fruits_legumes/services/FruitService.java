package com.project.fruits_legumes.services;

import com.project.fruits_legumes.models.Fruit;
import com.project.fruits_legumes.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Optional<Fruit> getFruitById(Long id) {
        return fruitRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return fruitRepository.existsById(id);
    }

    public void deleteFruitById(Long id) {
        fruitRepository.deleteById(id);
    }

}
