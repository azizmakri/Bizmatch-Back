package com.esprit.penetrationmarketing.repositories;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CampagneMarketingRepository extends JpaRepository<CampagneMarketing, Long> {
    List<CampagneMarketing> findByDateDebutBetween(Date startDate, Date endDate);
}
