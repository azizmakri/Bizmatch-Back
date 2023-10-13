package com.esprit.developpementbusiness.rest;

import com.esprit.developpementbusiness.persistence.entity.Opportunite;
import com.esprit.developpementbusiness.services.interfaces.OpportuniteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DevBusiness")
@AllArgsConstructor
public class OpportuniteController {
    @Autowired
    private OpportuniteService oppService;

    @PostMapping("/opportunite/add")
    public Opportunite add(@RequestBody Opportunite opportunite) {
        return oppService.save(opportunite);
    }
    @PutMapping("/opportunite/update")
    public Opportunite Update(@RequestBody Opportunite opportunite) {
        return	oppService.Update(opportunite);
    }

    @GetMapping("/opportunite/getAll")
    public List<Opportunite> getAll() {
        return oppService.findAll();
    }

    @GetMapping("/opportunite/getById/{id}")
    public Opportunite getById(@PathVariable Long id) {
        return oppService.findById(id);
    }

    @DeleteMapping("/opportunite/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return oppService.deleteById(id);
    }
}
