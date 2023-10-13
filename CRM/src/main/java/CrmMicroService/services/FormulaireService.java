package CrmMicroService.services;

import CrmMicroService.entities.Formulaire;

import java.util.List;

public interface FormulaireService {
     Formulaire createFormulaire(Formulaire formulaire);
     List<Formulaire> getAllFormulaires();
}
