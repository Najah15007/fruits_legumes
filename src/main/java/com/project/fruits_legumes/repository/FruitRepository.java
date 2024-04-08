package com.project.fruits_legumes.repository;

import com.project.fruits_legumes.models.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
