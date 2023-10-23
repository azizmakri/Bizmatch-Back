package com.esprit.bizmatch_gestionreunion.services;

import com.esprit.bizmatch_gestionreunion.entities.Reunion;

import java.util.List;

public interface IReunionService {

    Reunion createReunion(String username, Reunion reunion);
    Reunion getReunionById(Integer id);
    List<Reunion> getAllReunions();
    Reunion updateReunion(String username, Integer reunionId, Reunion updatedReunion);
    void deleteReunion(String username, Integer reunionId);
}
