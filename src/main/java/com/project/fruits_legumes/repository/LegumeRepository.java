package com.project.fruits_legumes.repository;

import com.project.fruits_legumes.models.Legume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegumeRepository extends JpaRepository<Legume, Long> {
}
