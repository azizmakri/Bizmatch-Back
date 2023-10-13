package com.esprit.developpementbusiness.repositories;

import com.esprit.developpementbusiness.persistence.entity.StrategieMarketing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrategieMarketingRepository extends JpaRepository<StrategieMarketing, Long> {

}
