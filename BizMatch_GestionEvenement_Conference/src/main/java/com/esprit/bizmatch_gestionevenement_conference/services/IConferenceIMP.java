package com.esprit.bizmatch_gestionevenement_conference.services;

import com.esprit.bizmatch_gestionevenement_conference.entities.Conference;
import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.User;
import com.esprit.bizmatch_gestionevenement_conference.repositories.ConferenceRepository;
import com.esprit.bizmatch_gestionevenement_conference.repositories.EvenementRepository;
import com.esprit.bizmatch_gestionevenement_conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IConferenceIMP implements IConferenceService{

    private ConferenceRepository conferenceRepository;
    private UserRepository userRepository;
    private EvenementRepository evenementRepository;

    @Override
    public Conference createConference(String username, Conference conference) {
        // Trouver l'organisateur par son nom d'utilisateur
        User organizer = userRepository.findByUserName(username);
        if (organizer == null) {
            throw new RuntimeException("Organizer not found");
        }

        // Associer l'organisateur à la conférence
        conference.setOrganisateur(organizer);

        // Enregistrer la conférence
        return conferenceRepository.save(conference);
    }

    @Override
    public Conference getConferenceById(Integer id) {
        return conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));
    }

    @Override
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }


    @Override
    public Conference updateConference(String username, Integer conferenceId, Conference updatedConference) {
        // Trouver la conférence par ID
        Conference existingConference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        // Vérifier si l'utilisateur est l'organisateur de la conférence
        if (!existingConference.getOrganisateur().getUserName().equals(username)) {
            throw new RuntimeException("Only the conference organizer can update the conference");
        }

        // Mettre à jour les détails de la conférence
        existingConference.setTitre(updatedConference.getTitre());
        existingConference.setTheme(updatedConference.getTheme());
        existingConference.setDescription(updatedConference.getDescription());
        existingConference.setTypeConference(updatedConference.getTypeConference());
        existingConference.setDateDebut(updatedConference.getDateDebut());
        existingConference.setDateFin(updatedConference.getDateFin());

        // Enregistrer la conférence mise à jour
        return conferenceRepository.save(existingConference);
    }

    @Override
    public void deleteConference(String username, Integer conferenceId) {
        // Trouver la conférence par ID
        Conference existingConference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        // Vérifier si l'utilisateur est l'organisateur de la conférence
        if (!existingConference.getOrganisateur().getUserName().equals(username)) {
            throw new RuntimeException("Only the conference organizer can delete the conference");
        }

        // Supprimer la conférence
        conferenceRepository.delete(existingConference);
    }
    @Override
    public Conference addConferenceToEvent(Integer eventId, Conference conference) {
        // Trouver l'événement par ID
        Evenement evenement = evenementRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Vérifier si la date de début de la conférence est antérieure à la date de début de l'événement
        if (conference.getDateDebut().before(evenement.getDateDebut())) {
            throw new RuntimeException("Conference start date should be before event start date");
        }

        // Associer la conférence à l'événement
        conference.setEvenement(evenement);
        evenement.getConferences().add(conference);
        evenementRepository.save(evenement);

        return conferenceRepository.save(conference);
    }
}
