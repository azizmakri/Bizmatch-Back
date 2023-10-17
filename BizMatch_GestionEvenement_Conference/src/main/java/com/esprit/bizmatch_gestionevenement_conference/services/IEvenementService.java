package com.esprit.bizmatch_gestionevenement_conference.services;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface IEvenementService {
    /*public Evenement createEvenement(Evenement evenement, String userName);*/

  /*  public Evenement updateEvenement(Evenement evenement, String userName);*/
  public Evenement updateEvenement(
          Integer eventId,
          String nom,
          String description,
          Date dateDebut,
          Date dateFin,
          MultipartFile image,
          String lieu,
          Integer nombreParticipants,
          String userName
  );
      public void deleteEvenement(Integer id, String userName);
    public Evenement getEvenementById(Integer id, String userName);
    List<Evenement> getAllEvenements();
    public List<Evenement> getAllEvenementsByUserId(String userName);
    public boolean addFile(MultipartFile file);
    public Evenement addEvenement(String nom, String description, Date dateDebut, Date dateFin, MultipartFile image, String lieu, Integer nombreParticipants, String userName) ;




    }
