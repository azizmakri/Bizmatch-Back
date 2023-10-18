package tn.esprit.CRMMs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.CRMMs.Entities.Formulaire;
import tn.esprit.CRMMs.Services.FormulaireService;

import java.util.List;
@RestController
@RequestMapping("/formulaires")
@CrossOrigin("http://localhost:4200")
public class FormulaireController {
    @Autowired
    private FormulaireService formulaireService;

    @PostMapping("/create")
    public Formulaire createFormulaire(@RequestBody Formulaire formulaire) {
        return formulaireService.createFormulaire(formulaire);
    }

    @GetMapping("/")
    public List<Formulaire> getAllFormulaires() {
        return formulaireService.getAllFormulaires();
    }

}
