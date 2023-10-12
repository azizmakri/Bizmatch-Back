package com.example.opportunitecollaboration.Services;

import java.util.List;

public interface CategorieService {

    Categorie addCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    Categorie retrieveCategorieById(Long idCategorie);
    List<Categorie> retrieveAllCategories();
    Boolean deleteCategorie(Long idCategorie);
}
