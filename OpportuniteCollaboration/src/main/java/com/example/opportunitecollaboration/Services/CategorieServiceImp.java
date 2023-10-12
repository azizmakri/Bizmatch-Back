package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImp implements CategorieService{

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie retrieveCategorieById(Long idCategorie) {
        return categorieRepository.findById(idCategorie).orElse(null);
    }

    @Override
    public List<Categorie> retrieveAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Boolean deleteCategorie(Long idCategorie) {
        if (categorieRepository.existsById(idCategorie)) {
            categorieRepository.deleteById(idCategorie);
            return true;
        }
        else {
            return false;
        }
    }
}
