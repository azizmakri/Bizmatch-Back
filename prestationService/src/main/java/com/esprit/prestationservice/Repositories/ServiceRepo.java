package com.esprit.prestationservice.Repositories;

import com.esprit.prestationservice.Entities.ServiceFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<ServiceFournisseur,Long> {
}
