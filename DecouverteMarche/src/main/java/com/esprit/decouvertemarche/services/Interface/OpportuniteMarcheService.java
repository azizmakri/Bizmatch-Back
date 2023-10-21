package com.esprit.decouvertemarche.services.Interface;

import com.esprit.decouvertemarche.persistence.entity.DecouverteMarche;
import com.esprit.decouvertemarche.persistence.entity.OpportuniteMarche;

import java.util.List;

public interface OpportuniteMarcheService {
    public OpportuniteMarche save(OpportuniteMarche opportuniteMarche);
    public OpportuniteMarche Update(OpportuniteMarche opportuniteMarche);
    public boolean deleteById(Long id);
    public  OpportuniteMarche findById(Long id);
    public List<OpportuniteMarche> findAll();

    public String notif(DecouverteMarche decouverteMarche, OpportuniteMarche opportuniteMarche);

    public OpportuniteMarche trouverMeilleurMatch(DecouverteMarche decouverteMarche) ;

    public String accepterMatch(OpportuniteMarche opportuniteMarche);
}
