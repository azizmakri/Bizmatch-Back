package com.esprit.developpementbusiness.repositories;

import com.esprit.developpementbusiness.persistence.entity.PerformanceCommerciale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceCommercialeRepository extends JpaRepository<PerformanceCommerciale, Long> {

}
