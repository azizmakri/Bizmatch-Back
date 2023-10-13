package com.esprit.developpementbusiness.repositories;

import com.esprit.developpementbusiness.persistence.entity.Opportunite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportuniteRepository extends JpaRepository<Opportunite, Long> {

}

