package com.esprit.prestationservice.Controller;

import com.esprit.prestationservice.Entities.Room;
import com.esprit.prestationservice.Entities.ServiceFournisseur;
import com.esprit.prestationservice.Services.IRoomService;
import com.esprit.prestationservice.Services.ServiceFournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prestationservice")
@CrossOrigin("*")
public class ServiceController {
    public final ServiceFournisseurService sfs;
    public final IRoomService roomService;

    @GetMapping("/getall")
    public List<ServiceFournisseur> getall(){
        return sfs.getAllServices();
    }

    @PostMapping("/add/{idUser}")
    public ServiceFournisseur addService(@RequestBody ServiceFournisseur s, @PathVariable String idUser){
        return sfs.addService(s,idUser);
    }


    @PutMapping("/edit/{idUser}/{idService}")
    public ServiceFournisseur editService(@RequestBody ServiceFournisseur c, @PathVariable String idUser,@PathVariable Long idService){
        return sfs.editService(c,idUser,idService);
    }

    @DeleteMapping("/delete/{idService}/{idUser}")
    public void deleteService(@PathVariable Long idService,@PathVariable String idUser){
        sfs.deleteService(idService,idUser);
    }
    @GetMapping("/getById/{idService}")
    public ServiceFournisseur getServiceById(@PathVariable Long idService){
        return sfs.getById(idService);
    }

    @PostMapping("/add-room/{idEntreprise}/{idFournisseur}/{idService}")
    public Room AddRoom(@RequestBody Room room,@PathVariable String idEntreprise,@PathVariable String idFournisseur,@PathVariable Long idService){
        return roomService.AddRoom(room,idEntreprise,idFournisseur,idService);
    }
    @DeleteMapping("/delete-room/{roomId}/{idUser}")
    public void deleteRoom(@PathVariable Long roomId,@PathVariable String idUser){
        roomService.deleteRoom(roomId,idUser);
    }
    @GetMapping("/getRoomById/{roomId}")
    public Room getRoomById(@PathVariable Long roomId){
        return roomService.getRoomById(roomId);
    }
    @GetMapping("/getRoomsByUser/{idUser}")
    public List<Room> getRoomsByUser(@PathVariable String idUser){
        return roomService.getRoomsByUser(idUser);
    }
}
