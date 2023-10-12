package com.esprit.gestionmarche.services.Interface;

import com.esprit.gestionmarche.persistence.entity.OpportuniteMarche;

import com.esprit.gestionmarche.persistence.entity.DecouverteMarche;


import java.util.List;

public interface OpportuniteMarcheService {
    public OpportuniteMarche save(OpportuniteMarche opportuniteMarche);
    public OpportuniteMarche Update(OpportuniteMarche opportuniteMarche);
    public boolean deleteById(Integer id);
    public  OpportuniteMarche findById(Integer id);
    public List<OpportuniteMarche> findAll();

    public String notif(DecouverteMarche decouverteMarche, OpportuniteMarche opportuniteMarche);

    public OpportuniteMarche trouverMeilleurMatch(DecouverteMarche decouverteMarche) ;

    public String accepterMatch(OpportuniteMarche opportuniteMarche);
}
