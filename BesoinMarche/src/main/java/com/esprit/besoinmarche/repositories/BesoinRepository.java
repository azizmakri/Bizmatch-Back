package com.esprit.besoinmarche.repositories;

import com.esprit.besoinmarche.persistence.entity.Besoin;
import com.esprit.besoinmarche.persistence.enumeration.TypeBesoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BesoinRepository extends JpaRepository<Besoin, Long> {
    List<Besoin> findByType(TypeBesoin type);
}
