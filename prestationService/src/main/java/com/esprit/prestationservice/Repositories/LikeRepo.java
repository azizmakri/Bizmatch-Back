package com.esprit.prestationservice.Repositories;

import com.esprit.prestationservice.Entities.LikeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<LikeService,Long> {
}
