package com.esprit.bizmatch_gestionreunion.repositories;

import com.esprit.bizmatch_gestionreunion.entities.NoteReunion;
import com.esprit.bizmatch_gestionreunion.entities.Reunion;
import com.esprit.bizmatch_gestionreunion.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteReunionRepository extends JpaRepository<NoteReunion,Integer> {
    boolean existsByUserAndReunion(User user, Reunion reunion);

}
