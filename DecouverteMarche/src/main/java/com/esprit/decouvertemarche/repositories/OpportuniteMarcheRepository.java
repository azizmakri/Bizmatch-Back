package com.esprit.decouvertemarche.repositories;

import com.esprit.decouvertemarche.persistence.entity.OpportuniteMarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportuniteMarcheRepository extends JpaRepository<OpportuniteMarche, Long> {
}
