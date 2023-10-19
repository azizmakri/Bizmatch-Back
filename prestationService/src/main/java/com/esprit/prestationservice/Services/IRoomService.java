package com.esprit.prestationservice.Services;

import com.esprit.prestationservice.Entities.Room;
import com.esprit.prestationservice.Entities.ServiceFournisseur;

import java.util.List;

public interface IRoomService {
    public void deleteRoom(Long roomId, String idUser);
    public Room AddRoom(Room room,String idEntreprise,String idFournisseur, Long idService);
    public Room getRoomById(Long roomId);
    public List<Room> getRoomsByUser(String idUser);

}
