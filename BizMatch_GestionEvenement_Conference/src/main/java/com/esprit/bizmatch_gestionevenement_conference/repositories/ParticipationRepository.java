package com.esprit.bizmatch_gestionevenement_conference.repositories;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.Participation;
import com.esprit.bizmatch_gestionevenement_conference.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation,Integer> {
    Participation findByEvenementAndUser(Evenement evenement, User user);
    long countByEvenement(Evenement evenement);

}
