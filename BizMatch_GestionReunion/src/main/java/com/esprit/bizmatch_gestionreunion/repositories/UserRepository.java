package com.esprit.bizmatch_gestionreunion.repositories;

import com.esprit.bizmatch_gestionreunion.entities.Role;
import com.esprit.bizmatch_gestionreunion.entities.RoleDemander;
import com.esprit.bizmatch_gestionreunion.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
    List<User> findByRoleDemander(RoleDemander role);
    // Ajoutez cette méthode pour récupérer les utilisateurs par rôle

}