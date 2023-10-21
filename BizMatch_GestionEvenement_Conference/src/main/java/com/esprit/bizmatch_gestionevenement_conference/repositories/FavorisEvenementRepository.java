package com.esprit.bizmatch_gestionevenement_conference.repositories;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.FavoriEvenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavorisEvenementRepository extends JpaRepository<FavoriEvenement,Integer> {
    List<FavoriEvenement> findByUser_UserName(String userName);
    FavoriEvenement findByUserAndEvenement(User user , Evenement evenement);
}
