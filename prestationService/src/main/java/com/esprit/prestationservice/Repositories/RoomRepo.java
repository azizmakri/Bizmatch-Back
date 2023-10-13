package com.esprit.prestationservice.Repositories;

import com.esprit.prestationservice.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room,Long> {
}
