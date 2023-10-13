package com.esprit.bizmatch_gestionevenement_conference.services;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.entities.User;
import com.esprit.bizmatch_gestionevenement_conference.repositories.EvenementRepository;
import com.esprit.bizmatch_gestionevenement_conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class IEvenementIMP implements IEvenementService{
    private EvenementRepository evenementRepository;
    private UserRepository userRepository;

    @Override
    public Evenement createEvenement(Evenement evenement, String userName) {
        User user = userRepository.findById(userName).orElse(null);
        evenement.setOrganisateur(user);
        return evenementRepository.save(evenement);
    }
 /* @Override
    public Evenement updateEvenement(Evenement evenement, String userName) {
        User user = userRepository.findById(userName).orElse(null);
        if (!evenement.getOrganisateur().equals(user)) {
            throw new RuntimeException("User not authorized to update this event");
        }
        return evenementRepository.save(evenement);
    }*/



    @Override
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
