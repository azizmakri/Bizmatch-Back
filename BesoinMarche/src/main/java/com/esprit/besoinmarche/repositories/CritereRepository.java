package com.esprit.besoinmarche.repositories;

import com.esprit.besoinmarche.persistence.entity.Critere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CritereRepository extends JpaRepository<Critere, Long> {
    List<Critere> findByNomAndValeur(String nom, Double valeur);
}
