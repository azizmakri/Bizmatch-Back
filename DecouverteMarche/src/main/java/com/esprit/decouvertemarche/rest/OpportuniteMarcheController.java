package com.esprit.decouvertemarche.rest;


import com.esprit.decouvertemarche.persistence.entity.DecouverteMarche;
import com.esprit.decouvertemarche.persistence.entity.OpportuniteMarche;
import com.esprit.decouvertemarche.services.Interface.DecouverteMarcheService;
import com.esprit.decouvertemarche.services.Interface.OpportuniteMarcheService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Marche")
@AllArgsConstructor
public class OpportuniteMarcheController {

    @Autowired
    private OpportuniteMarcheService opportuniteMarcheservice;
    @Autowired
    private DecouverteMarcheService service;




    @PostMapping("/opportuniteMarche/add")
    public OpportuniteMarche add(@RequestBody OpportuniteMarche opportuniteMarche) {
        return opportuniteMarcheservice.save(opportuniteMarche);
    }
    @PutMapping("/opportuniteMarche/update")
    public OpportuniteMarche Update(@RequestBody OpportuniteMarche opportuniteMarche) {
        return	opportuniteMarcheservice.Update(opportuniteMarche);
    }


    @GetMapping("/opportuniteMarche/getAll")
    public List<OpportuniteMarche> getAll() {
        return opportuniteMarcheservice.findAll();
    }

    @GetMapping("/opportuniteMarche/getById/{id}")
    public OpportuniteMarche getById(@PathVariable Long id) {
        return opportuniteMarcheservice.findById(id);
    }

    @DeleteMapping("/opportuniteMarche/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
       return opportuniteMarcheservice.deleteById(id);
    }

    @GetMapping("/opportuniteMarche/meilleurMatch/{decouverte}")
    public ResponseEntity<String> trouverMeilleurMatch(@PathVariable ("decouverte") DecouverteMarche decouverte){
        OpportuniteMarche meilleurMatch = opportuniteMarcheservice.trouverMeilleurMatch(decouverte);

        if (meilleurMatch == null) {
            return ResponseEntity.notFound().build();
        }

        String notifMessage = opportuniteMarcheservice.notif(decouverte, meilleurMatch);

        return ResponseEntity.ok().body(notifMessage);
    }


    @PostMapping("/opportuniteMarche/accepter")
    public ResponseEntity<String> accepterMatch(@RequestBody OpportuniteMarche match) {
        String message = opportuniteMarcheservice.accepterMatch(match);
        return ResponseEntity.ok(message);
    }

}
