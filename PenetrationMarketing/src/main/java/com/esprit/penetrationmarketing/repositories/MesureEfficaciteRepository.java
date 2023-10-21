package com.esprit.penetrationmarketing.repositories;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import com.esprit.penetrationmarketing.persistence.entity.MesureEfficacite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesureEfficaciteRepository extends JpaRepository<MesureEfficacite, Long> {
    List<MesureEfficacite> findByCampagneMarketing(CampagneMarketing campagneMarketing);
}