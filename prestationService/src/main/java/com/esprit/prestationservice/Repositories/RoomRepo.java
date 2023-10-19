package com.esprit.prestationservice.Repositories;

import com.esprit.prestationservice.Entities.Room;
import com.esprit.prestationservice.Entities.ServiceFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room,Long> {
}
