package com.example.opportunitecollaboration.Repositories;

import com.example.opportunitecollaboration.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}