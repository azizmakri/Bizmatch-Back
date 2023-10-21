package com.esprit.developpementbusiness.repositories;

import com.esprit.developpementbusiness.persistence.entity.ObjectifCommercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectifCommercialRepository extends JpaRepository<ObjectifCommercial, Long> {

}
