package tn.esprit.CRMMs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.CRMMs.Entities.Formulaire;
import tn.esprit.CRMMs.Repositories.FormulaireRepositories;

import java.util.List;
@Service

public class FormulaireServiceIMP implements  FormulaireService {
    @Autowired
    private FormulaireRepositories formulaireRepository;
    @Override
    public Formulaire createFormulaire(Formulaire formulaire) {
        return formulaireRepository.save(formulaire);
    }
    @Override
    public List<Formulaire> getAllFormulaires() {
        return formulaireRepository.findAll();
    }
}
