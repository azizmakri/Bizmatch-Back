package com.esprit.bizmatch_gestionreunion.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class INoteReunionServiceIMP implements INoteReunionService{

   /* @Override
    public NoteReunion addNoteToReunion(String username, Integer reunionId, NoteReunion noteReunion) {
        // Trouver la réunion par ID
        Reunion reunion = reunionRepository.findById(reunionId)
                .orElseThrow(() -> new RuntimeException("Réunion non trouvée"));

        // Trouver l'utilisateur par nom d'utilisateur
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }

        // Vérifier que l'utilisateur n'est pas l'organisateur de la réunion
        if (reunion.getOrganisateur().getUserName().equals(username)) {
            throw new RuntimeException("L'organisateur ne peut pas noter la réunion");
        }

        // Vérifier que la notation est dans la plage valide (1 à 5)
        Integer rating = noteReunion.getRating();
        if (rating == null || rating < 1 || rating > 5) {
            throw new RuntimeException("La notation doit être entre 1 et 5");
        }

        // Associer la note à la réunion
        noteReunion.setReunion(reunion);

        // Enregistrer la note de réunion avec le champ de notation
        return noteReunionRepository.save(noteReunion);
    }
*/
}
