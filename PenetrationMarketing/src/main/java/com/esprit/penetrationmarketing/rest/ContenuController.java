package com.esprit.penetrationmarketing.rest;

import com.esprit.penetrationmarketing.persistence.entity.Contenu;
import com.esprit.penetrationmarketing.services.interfaces.ContenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marketing")
@AllArgsConstructor
public class ContenuController {
    @Autowired
    private ContenuService contenuService;

    @PostMapping("/contenu/add")
    public Contenu add(@RequestBody Contenu contenu) {
        return contenuService.save(contenu);
    }
    @PutMapping("/contenu/update")
    public Contenu Update(@RequestBody Contenu contenu) {
        return	contenuService.Update(contenu);
    }

    @GetMapping("/contenu/getAll")
    public List<Contenu> getAll() {
        return contenuService.findAll();
    }

    @GetMapping("/contenu/getById/{id}")
    public Contenu getById(@PathVariable Long id) {
        return contenuService.findById(id);
    }

    @DeleteMapping("/contenu/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return contenuService.deleteById(id);
    }

}
