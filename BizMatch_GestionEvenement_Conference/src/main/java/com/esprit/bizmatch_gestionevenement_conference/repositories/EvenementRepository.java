package com.esprit.bizmatch_gestionevenement_conference.repositories;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement,Integer> {
    List<Evenement> findAllByOrganisateur(User organisateur);
}
