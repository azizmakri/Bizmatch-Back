package com.esprit.gestionmarche.rest;


import com.esprit.gestionmarche.persistence.entity.DecouverteMarche;
import com.esprit.gestionmarche.persistence.entity.OpportuniteMarche;
import com.esprit.gestionmarche.services.Interface.DecouverteMarcheService;
import com.esprit.gestionmarche.services.Interface.OpportuniteMarcheService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/opportuniteMarche")
@AllArgsConstructor
public class OpportuniteMarcheController {

    @Autowired
    private OpportuniteMarcheService opportuniteMarcheservice;
    @Autowired
    private DecouverteMarcheService service;



    @PostMapping("/add")
    @CrossOrigin
    void add(@Validated @RequestBody OpportuniteMarche a) {
        if (Objects.nonNull(a.getDecouverteMarche()) && Objects.nonNull(a.getDecouverteMarche().getId())) {
            DecouverteMarche decouverteMarche = service.findById(a.getDecouverteMarche().getId());
            a.setDecouverteMarche(decouverteMarche);
        }
        opportuniteMarcheservice.save(a);
    }
    @PutMapping("/update")
    public OpportuniteMarche Update(@RequestBody OpportuniteMarche opportuniteMarche) {
        return	opportuniteMarcheservice.Update(opportuniteMarche);
    }


    @GetMapping("/getAll")
    public List<OpportuniteMarche> getAll() {
        return opportuniteMarcheservice.findAll();
    }

    @GetMapping("/getById/{id}")
    public OpportuniteMarche getById(@PathVariable Integer id) {
        return opportuniteMarcheservice.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable Integer id) {
       return opportuniteMarcheservice.deleteById(id);
    }

    @GetMapping("/meilleurMatch/{decouverte}")
    public ResponseEntity<String> trouverMeilleurMatch(@PathVariable ("decouverte") DecouverteMarche decouverte){
        OpportuniteMarche meilleurMatch = opportuniteMarcheservice.trouverMeilleurMatch(decouverte);

        if (meilleurMatch == null) {
            return ResponseEntity.notFound().build();
        }

        String notifMessage = opportuniteMarcheservice.notif(decouverte, meilleurMatch);

        return ResponseEntity.ok().body(notifMessage);
    }


    @PostMapping("/accepter")
    public ResponseEntity<String> accepterMatch(@RequestBody OpportuniteMarche match) {
        String message = opportuniteMarcheservice.accepterMatch(match);
        return ResponseEntity.ok(message);
    }

}
