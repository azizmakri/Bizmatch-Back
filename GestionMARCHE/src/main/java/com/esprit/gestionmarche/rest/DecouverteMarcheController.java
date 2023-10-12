package com.esprit.gestionmarche.rest;

import com.esprit.gestionmarche.persistence.entity.DecouverteMarche;
import com.esprit.gestionmarche.persistence.entity.OpportuniteMarche;
import com.esprit.gestionmarche.services.Interface.DecouverteMarcheService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decMarche")
@AllArgsConstructor
public class DecouverteMarcheController {
    @Autowired
    private DecouverteMarcheService service;

    @PostMapping("/add")
    public DecouverteMarche add(@RequestBody DecouverteMarche decouverteMarche) {
        return service.save(decouverteMarche);
    }
    @PutMapping("/update")
    public DecouverteMarche Update(@RequestBody DecouverteMarche decouverteMarche) {
        return	service.Update(decouverteMarche);
    }

    @GetMapping("/getAll")
    public List<DecouverteMarche> getAll() {
        return service.findAll();
    }

    @GetMapping("/getById/{id}")
    public DecouverteMarche getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }


}
