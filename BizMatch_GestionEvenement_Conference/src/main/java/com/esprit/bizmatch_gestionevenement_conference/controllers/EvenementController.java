package com.esprit.bizmatch_gestionevenement_conference.controllers;

import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.services.IEvenementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/evenement")
public class EvenementController {
    IEvenementService iEvenementService;

    @PostMapping("/create/{userName}")
    public Evenement createEvenement(@RequestBody Evenement evenement, @PathVariable String userName) {
        return iEvenementService.createEvenement(evenement,userName);
    }

    @PutMapping("/update/{userName}")
    public Evenement updateEvenement(@RequestBody Evenement evenement, @PathVariable String userName) {
        return iEvenementService.updateEvenement(evenement, userName);
    }

    @DeleteMapping("/delete/{id}/{userName}")
    public void deleteEvenement(@PathVariable Integer idEvent, @PathVariable String userName) {
        iEvenementService.deleteEvenement(idEvent, userName);
    }

    @GetMapping("/get/{idEvent}/{userName}")
    public Evenement getEvenementById(@PathVariable Integer idEvent, @PathVariable String userName) {
        return iEvenementService.getEvenementById(idEvent, userName);
    }

    @GetMapping("/getAllEvents")
    public List<Evenement> getAllEvents(){
        return iEvenementService.getAllEvenements();
    }
    @GetMapping("/allEvents/{userName}")
    public List<Evenement> getAllEvenementsByUserId(@RequestParam String userName) {
        return iEvenementService.getAllEvenementsByUserId(userName);
    }

}
