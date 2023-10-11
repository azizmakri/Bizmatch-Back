package com.esprit.bizmatch_gestionevenement_conference.repositories;

import com.esprit.bizmatch_gestionevenement_conference.entities.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation,Integer> {
}
