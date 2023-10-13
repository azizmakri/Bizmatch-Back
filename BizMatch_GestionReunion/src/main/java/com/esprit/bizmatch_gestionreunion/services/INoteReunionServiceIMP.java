package com.esprit.bizmatch_gestionreunion.services;

import com.esprit.bizmatch_gestionreunion.entities.NoteReunion;
import com.esprit.bizmatch_gestionreunion.entities.Reunion;
import com.esprit.bizmatch_gestionreunion.entities.User;
import com.esprit.bizmatch_gestionreunion.repositories.NoteReunionRepository;
import com.esprit.bizmatch_gestionreunion.repositories.ReunionRepository;
import com.esprit.bizmatch_gestionreunion.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class INoteReunionServiceIMP implements INoteReunionService{

    private ReunionRepository reunionRepository;
    private UserRepository userRepository ;
    private NoteReunionRepository noteReunionRepository ;
    @Override
    public NoteReunion addNoteToReunion(String username, Integer reunionId, NoteReunion noteReunion) {
        // Trouver la réunion par ID
        Reunion reunion = reunionRepository.findById(reunionId)
                .orElseThrow(() -> new RuntimeException("Réunion non trouvée"));

        // Trouver l'utilisateur par nom d'utilisateur
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }

        // Vérifier que la notation est dans la plage valide (1 à 5)
        Integer rating = noteReunion.getRating();
        if (rating == null || rating < 1 || rating > 5) {
            throw new RuntimeException("La notation doit être entre 1 et 5");
        }

        // Vérifier si l'utilisateur est l'organisateur de la réunion
        if (user.equals(reunion.getOrganisateur())) {
            throw new RuntimeException("L'organisateur ne peut pas noter la réunion qu'il organise");
        }

        // Vérifier si l'utilisateur a déjà noté cette réunion
        boolean userAlreadyNotedReunion = noteReunionRepository.existsByUserAndReunion(user, reunion);
        if (userAlreadyNotedReunion) {
            throw new RuntimeException("L'utilisateur a déjà noté cette réunion");
        }

        // Associer la note à la réunion et à l'utilisateur
        noteReunion.setReunion(reunion);
        noteReunion.setUser(user);

        // Enregistrer la nouvelle note de réunion
        return noteReunionRepository.save(noteReunion);
    }


}
