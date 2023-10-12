package com.esprit.gestionmarche.repositories;

import com.esprit.gestionmarche.persistence.entity.OpportuniteMarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportuniteMarcheRepository extends JpaRepository<OpportuniteMarche, Integer> {
}
