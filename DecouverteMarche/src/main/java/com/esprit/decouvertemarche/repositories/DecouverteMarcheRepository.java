package com.esprit.decouvertemarche.repositories;

import com.esprit.decouvertemarche.persistence.entity.DecouverteMarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecouverteMarcheRepository extends JpaRepository<DecouverteMarche, Long> {
}
