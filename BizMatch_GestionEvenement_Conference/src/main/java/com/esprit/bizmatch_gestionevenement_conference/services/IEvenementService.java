package com.esprit.bizmatch_gestionevenement_conference.services;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;

import java.util.List;

public interface IEvenementService {
    public Evenement createEvenement(Evenement evenement, String userName);
    public Evenement updateEvenement(Evenement evenement, String userName);
    public void deleteEvenement(Integer id, String userName);
    public Evenement getEvenementById(Integer id, String userName);
    List<Evenement> getAllEvenements();
    public List<Evenement> getAllEvenementsByUserId(String userName);
}
