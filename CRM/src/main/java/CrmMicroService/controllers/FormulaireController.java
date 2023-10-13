package CrmMicroService.controllers;
import CrmMicroService.entities.Formulaire;
import CrmMicroService.services.FormulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/formulaires")
public class FormulaireController {
    @Autowired
    private FormulaireService formulaireService;

    @PostMapping("/")
    public Formulaire createFormulaire(@RequestBody Formulaire formulaire) {
        return formulaireService.createFormulaire(formulaire);
    }

    @GetMapping("/")
    public List<Formulaire> getAllFormulaires() {
        return formulaireService.getAllFormulaires();
    }

}

