package com.esprit.bizmatch_gestionevenement_conference.services;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.User;
import com.esprit.bizmatch_gestionevenement_conference.repositories.EvenementRepository;
import com.esprit.bizmatch_gestionevenement_conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;


import java.util.Date;
import java.util.List;



@Slf4j
@Service
public class IEvenementIMP implements IEvenementService{
    @Value("${file.upload}")
    private String pathFile;
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired

    private UserRepository userRepository;

    /*@Override
    public Evenement createEvenement(Evenement evenement, String userName) {
        User user = userRepository.findById(userName).orElse(null);
        evenement.setOrganisateur(user);
        return evenementRepository.save(evenement);
    }*/

    @Override
    public boolean addFile(MultipartFile file) {
        try {
            File convertFile = new File(pathFile + file.getOriginalFilename());


            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
        } catch (Exception e) {

            log.error("upload file :",e.getMessage());

            return false;

        }
        return true;

    }
    @Override
    public Evenement addEvenement(String nom, String description, Date dateDebut, Date dateFin, MultipartFile image, String lieu, Integer nombreParticipants, String userName) {
        // Sauvegarde de l'image
        boolean fileAdded = addFile(image);
        if (!fileAdded) {
            throw new RuntimeException("Erreur lors de la sauvegarde de l'image.");
        }
        String imagePath = pathFile + image.getOriginalFilename();

        // Création de l'objet Evenement
        Evenement evenement = new Evenement();
        evenement.setNom(nom);
        evenement.setDescription(description);
        evenement.setDateDebut(dateDebut);
        evenement.setDateFin(dateFin);
        evenement.setImagePath(imagePath);
        evenement.setLieu(lieu);
        evenement.setNombreParticipants(nombreParticipants);

        // Récupération de l'organisateur par son nom d'utilisateur
        User user = userRepository.findById(userName).orElse(null);
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable : " + userName);
        }

        evenement.setOrganisateur(user);

        Evenement savedEvenement = evenementRepository.save(evenement);

        return savedEvenement;
    }

 /* @Override
    public Evenement updateEvenement(Evenement evenement, String userName) {
        User user = userRepository.findById(userName).orElse(null);
        if (!evenement.getOrganisateur().equals(user)) {
            throw new RuntimeException("User not authorized to update this event");
        }
        return evenementRepository.save(evenement);
    }*/

   /* @Override
    public Evenement updateEvenement(Evenement evenement, String userName) {
        if (evenement == null || userName == null) {
            throw new IllegalArgumentException("Event and username must not be null");
        }

        User user = userRepository.findByUserName(userName);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (evenement.getOrganisateur() == user) {
            evenementRepository.save(evenement);
        }

        evenement.setOrganisateur(user);
        return evenementRepository.save(evenement);
    }*/

    @Override
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
    ) {
        if (eventId == null || userName == null) {
            throw new IllegalArgumentException("Event ID and username must not be null");
        }

        User user = userRepository.findByUserName(userName);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Evenement evenement = evenementRepository.findById(eventId).orElse(null);

        if (evenement == null) {
            throw new RuntimeException("Event not found");
        }

        // Vérifier si l'utilisateur est l'organisateur de l'événement
        if (!evenement.getOrganisateur().equals(user)) {
            throw new RuntimeException("User is not the organizer of this event");
        }

        // Mettre à jour les propriétés de l'événement
        evenement.setNom(nom);
        evenement.setDescription(description);
        evenement.setDateDebut(dateDebut);
        evenement.setDateFin(dateFin);
        evenement.setLieu(lieu);
        evenement.setNombreParticipants(nombreParticipants);

        // Mettre à jour l'image si un nouveau fichier est fourni
        if (image != null && !image.isEmpty()) {
            // Sauvegarde de la nouvelle image
            boolean fileAdded = addFile(image);
            if (!fileAdded) {
                throw new RuntimeException("Erreur lors de la sauvegarde de la nouvelle image.");
            }
            String newImagePath = pathFile + image.getOriginalFilename();
            evenement.setImagePath(newImagePath);
        }

        return evenementRepository.save(evenement);
    }



    @Override
    public void deleteEvenement(Integer idEvent, String userName) {
        Evenement evenement = evenementRepository.findById(idEvent)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        User user = userRepository.findById(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!evenement.getOrganisateur().equals(user)) {
            throw new RuntimeException("User not authorized to delete this event");
        }
        evenementRepository.deleteById(idEvent);
    }

    @Override
    public Evenement getEvenementById(Integer idEvent, String userName) {
        Evenement evenement = evenementRepository.findById(idEvent)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        User user = userRepository.findById(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!evenement.getOrganisateur().equals(user)) {
            throw new RuntimeException("User not authorized to view this event");
        }
        return evenement;
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }
    @Override
    public List<Evenement> getAllEvenementsByUserId(String userName) {
        User user = userRepository.findById(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return evenementRepository.findAllByOrganisateur(user);
    }





}
