package com.esprit.gestionmarche.services.Interface;

import com.esprit.gestionmarche.persistence.entity.DecouverteMarche;
import com.esprit.gestionmarche.persistence.entity.OpportuniteMarche;

import java.util.List;

public interface DecouverteMarcheService {
    public DecouverteMarche save(DecouverteMarche decouverteMarche);
    public DecouverteMarche Update(DecouverteMarche decouverteMarche);

    public List<DecouverteMarche> findAll();
    public  DecouverteMarche findById(Integer id);
    public boolean deleteById(Integer id);

    }
