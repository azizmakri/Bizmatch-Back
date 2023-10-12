package com.esprit.bizmatch_gestionreunion.services;

import com.esprit.bizmatch_gestionreunion.entities.Reunion;
import com.esprit.bizmatch_gestionreunion.entities.User;
import com.esprit.bizmatch_gestionreunion.repositories.ReunionRepository;
import com.esprit.bizmatch_gestionreunion.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IReunionServiceIMP implements IReunionService{

    private final ReunionRepository reunionRepository;
    private final UserRepository userRepository;
    @Override
    public Reunion createReunion(String username, Reunion reunion) {
        User organizer = userRepository.findByUserName(username);
        if (organizer == null) {
            throw new RuntimeException("Organizer not found");
        }

        reunion.setOrganisateur(organizer);
        return reunionRepository.save(reunion);
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
        existingReunion.setDateDebut(updatedReunion.getDateDebut());
        existingReunion.setDateFin(updatedReunion.getDateFin());
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
