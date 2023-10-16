package com.esprit.besoinmarche.repositories;

import com.esprit.besoinmarche.persistence.entity.Critere;
import com.esprit.besoinmarche.persistence.entity.Marche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcheRepository extends JpaRepository<Marche, Long> {
    List<Marche> findByCriteresIn(List<Critere> criteres);
}
