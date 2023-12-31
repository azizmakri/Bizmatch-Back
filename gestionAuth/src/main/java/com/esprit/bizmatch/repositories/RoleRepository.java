package com.esprit.bizmatch.repositories;

import com.esprit.bizmatch.persistence.entity.Role;
import com.esprit.bizmatch.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
