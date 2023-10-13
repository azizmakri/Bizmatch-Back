package com.esprit.bizmatch_gestionreunion.repositories;

import com.esprit.bizmatch_gestionreunion.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
}