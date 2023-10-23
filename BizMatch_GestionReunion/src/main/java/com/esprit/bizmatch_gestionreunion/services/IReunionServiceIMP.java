package com.esprit.bizmatch_gestionreunion.services;

import com.esprit.bizmatch_gestionreunion.EmailService;
import com.esprit.bizmatch_gestionreunion.entities.Reunion;
import com.esprit.bizmatch_gestionreunion.entities.Role;
import com.esprit.bizmatch_gestionreunion.entities.RoleDemander;
import com.esprit.bizmatch_gestionreunion.entities.User;
import com.esprit.bizmatch_gestionreunion.repositories.ReunionRepository;
import com.esprit.bizmatch_gestionreunion.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class IReunionServiceIMP implements IReunionService{

    private final ReunionRepository reunionRepository;
    private final UserRepository userRepository;
    private EmailService emailService;

    @Override
    public Reunion createReunion(String username, Reunion reunion) {
        // Récupérez l'organisateur
        User organizer = userRepository.findByUserName(username);
        if (organizer == null) {
            throw new RuntimeException("Organizer not found");
        }

        // Assurez-vous que l'URL de la réunion est valide
        if (!isValidUrl(reunion.getUrlReunion())) {
            throw new RuntimeException("L'URL de la réunion n'est pas valide.");
        }

        // Enregistrez l'organisateur dans la réunion
        reunion.setOrganisateur(organizer);

        // Enregistrez la réunion dans la base de données
        Reunion nouvelleReunion = reunionRepository.save(reunion);

        // Récupérez la liste des utilisateurs avec le rôle "Représentant"
        List<User> representants = userRepository.findByRoleDemander(RoleDemander.Représentant);

        // Parcourez la liste des représentants et envoyez un e-mail à chacun d'eux
        for (User representant : representants) {
            String subject = "Nouvelle réunion disponible";
            String message = "Une nouvelle réunion est disponible avec l'URL : " + nouvelleReunion.getUrlReunion();
            emailService.sendEmail(representant.getUserEmail(), subject, message);
        }

        return nouvelleReunion;
    }

    // Méthode utilitaire pour vérifier si une URL est valide
    private boolean isValidUrl(String url) {
        // Vous pouvez mettre en place ici la logique de validation de l'URL
        // Par exemple, vérifiez si l'URL commence par "https://meet.google.com/"
        // ou utilisez des expressions régulières pour une validation plus avancée.
        return url != null && url.startsWith("https://meet.google.com/");
    }


    @Override
    public Reunion getReunionById(Integer id) {
        return reunionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reunion not found"));
    }

    @Override
    public List<Reunion> getAllReunions() {
        return reunionRepository.findAll();
    }

    @Override
    public Reunion updateReunion(String username, Integer reunionId, Reunion updatedReunion) {
        Reunion existingReunion = reunionRepository.findById(reunionId)
                .orElseThrow(() -> new RuntimeException("Reunion not found"));

        if (!existingReunion.getOrganisateur().getUserName().equals(username)) {
            throw new RuntimeException("Only the reunion organizer can update the reunion");
        }

        existingReunion.setSujet(updatedReunion.getSujet());
        existingReunion.setDateReunion(updatedReunion.getDateReunion());
        existingReunion.setLieu(updatedReunion.getLieu());
        existingReunion.setTypeReunion(updatedReunion.getTypeReunion());
        existingReunion.setUrlReunion(updatedReunion.getUrlReunion());

        return reunionRepository.save(existingReunion);
    }

    @Override
    public void deleteReunion(String username, Integer reunionId) {
        Reunion existingReunion = reunionRepository.findById(reunionId)
                .orElseThrow(() -> new RuntimeException("Reunion not found"));

        if (!existingReunion.getOrganisateur().getUserName().equals(username)) {
            throw new RuntimeException("Only the reunion organizer can delete the reunion");
        }

        reunionRepository.delete(existingReunion);
    }




}
