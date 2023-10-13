package com.esprit.penetrationmarketing.repositories;

import com.esprit.penetrationmarketing.persistence.entity.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenuRepository extends JpaRepository<Contenu, Long> {
}
