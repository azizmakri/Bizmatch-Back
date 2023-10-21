package com.esprit.decouvertemarche.rest;

import com.esprit.decouvertemarche.persistence.entity.DecouverteMarche;
import com.esprit.decouvertemarche.services.Interface.DecouverteMarcheService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Marche")
@AllArgsConstructor
public class DecouverteMarcheController {
    @Autowired
    private DecouverteMarcheService service;

    @PostMapping("/decMarche/add")
    public DecouverteMarche add(@RequestBody DecouverteMarche decouverteMarche) {
        return service.save(decouverteMarche);
    }
    @PutMapping("/decMarche/update")
    public DecouverteMarche Update(@RequestBody DecouverteMarche decouverteMarche) {
        return	service.Update(decouverteMarche);
    }

    @GetMapping("/decMarche/getAll")
    public List<DecouverteMarche> getAll() {
        return service.findAll();
    }

    @GetMapping("/decMarche/getById/{id}")
    public DecouverteMarche getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/decMarche/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }


}
