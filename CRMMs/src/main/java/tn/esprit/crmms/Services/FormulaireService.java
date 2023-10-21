package tn.esprit.CRMMs.Services;

import tn.esprit.CRMMs.Entities.Formulaire;

import java.util.List;

public interface FormulaireService {
    Formulaire createFormulaire(Formulaire formulaire);
    List<Formulaire> getAllFormulaires();
}
