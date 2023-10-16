package com.example.partenairespotentiels.Repositories;

import com.example.partenairespotentiels.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}