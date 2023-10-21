package com.esprit.besoinmarche.rest;

import com.esprit.besoinmarche.persistence.entity.Besoin;
import com.esprit.besoinmarche.persistence.entity.Marche;
import com.esprit.besoinmarche.services.interfaces.MarcheService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/besoinMarche")
@AllArgsConstructor
public class MarcheController {

    @Autowired
    private MarcheService marcheService;

    @PostMapping("/marche/add")
    public Marche add(@RequestBody Marche marche) {
        return marcheService.save(marche);
    }
    @PutMapping("/marche/update")
    public Marche Update(@RequestBody Marche marche) {
        return	marcheService.Update(marche);
    }

    @GetMapping("/marche/getAll")
    public List<Marche> getAll() {
        return marcheService.findAll();
    }

    @GetMapping("/marche/getById/{id}")
    public Marche getById(@PathVariable Long id) {
        return marcheService.findById(id);
    }

    @DeleteMapping("/marche/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return marcheService.deleteById(id);
    }
    @GetMapping("/marche/search/{nom}/{valeur}")
    public List<Marche> searchMarches(@PathVariable String nom, @PathVariable Double valeur) {
        return marcheService.findMarchesByCritere(nom, valeur);
    }

    @GetMapping("/marche/best-match/{besoinId}")
    public List<Marche> findBestMatch(@PathVariable long besoinId) {
        return marcheService.findBestMatch(besoinId);
    }
}
