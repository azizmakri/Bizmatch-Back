package com.esprit.decouvertemarche.services.Interface;

import com.esprit.decouvertemarche.persistence.entity.DecouverteMarche;

import java.util.List;

public interface DecouverteMarcheService {
    public DecouverteMarche save(DecouverteMarche decouverteMarche);
    public DecouverteMarche Update(DecouverteMarche decouverteMarche);

    public List<DecouverteMarche> findAll();
    public  DecouverteMarche findById(Long id);
    public boolean deleteById(Long id);

    }
