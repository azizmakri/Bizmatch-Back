package com.esprit.bizmatch_gestionevenement_conference.repositories;

import com.esprit.bizmatch_gestionevenement_conference.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference,Integer> {
}
