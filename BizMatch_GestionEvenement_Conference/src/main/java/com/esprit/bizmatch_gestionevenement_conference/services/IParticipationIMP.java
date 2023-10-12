package com.esprit.bizmatch_gestionevenement_conference.services;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.Participation;
import com.esprit.bizmatch_gestionevenement_conference.entities.User;
import com.esprit.bizmatch_gestionevenement_conference.repositories.EvenementRepository;
import com.esprit.bizmatch_gestionevenement_conference.repositories.ParticipationRepository;
import com.esprit.bizmatch_gestionevenement_conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class IParticipationIMP implements IParticipationService {
    private final EvenementRepository evenementRepository;
    private final ParticipationRepository participationRepository;
    private final UserRepository userRepository;

    public String participateInEvent(Integer eventId, String userName) {
        // Trouver l'événement par ID
        Evenement evenement = evenementRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Rechercher l'utilisateur par son nom d'utilisateur
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Vérifier si l'utilisateur a déjà participé
        Participation existingParticipation = participationRepository.findByEvenementAndUser(evenement, user);
        if (existingParticipation != null) {
            // Supprimer la participation existante
            participationRepository.delete(existingParticipation);
            return "Existing participation removed, you can participate again.";
        }

        // Compter le nombre de participations actuelles pour cet événement
        long currentParticipants = participationRepository.countByEvenement(evenement);

        // Vérifier la disponibilité des places
        if (currentParticipants < evenement.getNombreParticipants()) {
            // Enregistrer la nouvelle participation
            Participation participation = new Participation();
            participation.setEvenement(evenement);
            participation.setUser(user);
            participationRepository.save(participation);

            return "Participation registered successfully";
        } else {
            return "No available spots for the event";
        }
    }

}
