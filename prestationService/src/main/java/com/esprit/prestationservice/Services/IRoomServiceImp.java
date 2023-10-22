package com.esprit.prestationservice.Services;

import com.esprit.prestationservice.Entities.Room;
import com.esprit.prestationservice.Entities.ServiceFournisseur;
import com.esprit.prestationservice.Entities.User;
import com.esprit.prestationservice.Repositories.RoomRepo;
import com.esprit.prestationservice.Repositories.ServiceRepo;
import com.esprit.prestationservice.Repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IRoomServiceImp implements IRoomService{
    public final UserRepo userRepo;
    public final ServiceRepo serviceRepo;
    public final RoomRepo roomRepo;

    @Override
    public void deleteRoom(Long roomId, String idUser) {
        User user =userRepo.findById(idUser).orElse(null);
        Room room=roomRepo.findById(roomId).orElse(null);
        if(user!=null&&room!=null){
            if (room.getUsers().contains(user))
                roomRepo.deleteById(roomId);
        }
    }

    @Override
    public Room AddRoom(Room room, String idEntreprise, String idFournisseur, Long idService) {
        User entreprise = userRepo.findById(idEntreprise).orElse(null);
        System.out.println(entreprise.getUserName());

        User fournisseur =userRepo.findById(idFournisseur).orElse(null);

        ServiceFournisseur serviceFournisseur=serviceRepo.findById(idService).orElse(null);
        List<User> users=new ArrayList<>();
        users.add(entreprise);
        users.add(fournisseur);
        room.setUsers(users);
        room.setServiceFournisseur(serviceFournisseur);
        room.setRoomName(entreprise.getUserName()+" "+fournisseur.getUserName()+" "+serviceFournisseur.getNomService());
        return roomRepo.save(room);
    }

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepo.findById(roomId).orElse(null);
    }

    @Override
    public List<Room> getRoomsByUser(String idUser) {
        User user=userRepo.findById(idUser).orElse(null);
        List<Room> rooms =new ArrayList<>();
        for (Room r:roomRepo.findAll()) {
            if (r.getUsers().contains(user)){
                rooms.add(r);
            }
        }
        return rooms;
    }
}
