package com.esprit.besoinmarche.services.interfaces;

import com.esprit.besoinmarche.persistence.entity.Besoin;
import com.esprit.besoinmarche.persistence.entity.Marche;

import java.util.List;

public interface MarcheService {
    public Marche save(Marche marche);
    public Marche Update(Marche marche);

    public List<Marche> findAll();
    public  Marche findById(Long id);
    public boolean deleteById(Long id);
    public List<Marche> findBestMatch(long besoinId);
    public List<Marche> findMarchesByCritere(String nom, Double valeur);
}
