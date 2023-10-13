package com.esprit.prestationservice.Controller;

import com.esprit.prestationservice.Entities.ServiceFournisseur;
import com.esprit.prestationservice.Services.ServiceFournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prestationservice")
public class ServiceController {
    public final ServiceFournisseurService sfs;

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
    public void deleteComment(@PathVariable Long idService,@PathVariable String idUser){
        sfs.deleteService(idService,idUser);
    }
    @GetMapping("/getById/{idService}")
    public ServiceFournisseur getCommById(@PathVariable Long idService){
        return sfs.getById(idService);
    }

}
