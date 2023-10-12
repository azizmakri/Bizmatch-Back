package com.esprit.gestionmarche.repositories;

import com.esprit.gestionmarche.persistence.entity.DecouverteMarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecouverteMarcheRepository extends JpaRepository<DecouverteMarche, Integer> {
}
