package com.esprit.besoinmarche.rest;

import com.esprit.besoinmarche.persistence.entity.Critere;
import com.esprit.besoinmarche.services.interfaces.CritereService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/besoinMarche")
@AllArgsConstructor
public class CritereController {
    @Autowired
    private CritereService critereService;

    @PostMapping("/critere/add")
    public Critere add(@RequestBody Critere critere) {
        return critereService.save(critere);
    }
    @PutMapping("/critere/update")
    public Critere Update(@RequestBody Critere critere) {
        return	critereService.Update(critere);
    }

    @GetMapping("/critere/getAll")
    public List<Critere> getAll() {
        return critereService.findAll();
    }

    @GetMapping("/critere/getById/{id}")
    public Critere getById(@PathVariable Long id) {
        return critereService.findById(id);
    }

    @DeleteMapping("/critere/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return critereService.deleteById(id);
    }
}
