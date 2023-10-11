package com.esprit.bizmatch_gestionevenement_conference.repositories;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement,Integer> {
}
