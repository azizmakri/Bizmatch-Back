package com.esprit.bizmatch_gestionreunion.repositories;

import com.esprit.bizmatch_gestionreunion.entities.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReunionRepository extends JpaRepository<Reunion,Integer> {
}
