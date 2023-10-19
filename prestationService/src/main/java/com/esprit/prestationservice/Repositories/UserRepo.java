package com.esprit.prestationservice.Repositories;

import com.esprit.prestationservice.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
