package com.esprit.decouvertemarche.repositories;

import com.esprit.decouvertemarche.persistence.entity.Tendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TendanceRepository extends JpaRepository<Tendance, Long> {
}
