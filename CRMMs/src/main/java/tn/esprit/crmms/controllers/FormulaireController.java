package tn.esprit.CRMMs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.CRMMs.Entities.Formulaire;
import tn.esprit.CRMMs.Entities.User;
import tn.esprit.CRMMs.Repositories.UserRepository;
import tn.esprit.CRMMs.Services.FormulaireService;

import java.util.List;
@RestController
@RequestMapping("/formulaires")
//@CrossOrigin("http://localhost:4200")
public class FormulaireController {
    @Autowired
    private FormulaireService formulaireService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create/{userName}")
    public Formulaire createFormulaire(@RequestBody Formulaire formulaire ,@PathVariable String userName) {
        User user = userRepository.findById(userName).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userName);
        }
        formulaire.setUser(user);

        return formulaireService.createFormulaire(formulaire);
    }

    @GetMapping("/getallclaim")
    public List<Formulaire> getAllFormulaires() {
        return formulaireService.getAllFormulaires();
    }

}
