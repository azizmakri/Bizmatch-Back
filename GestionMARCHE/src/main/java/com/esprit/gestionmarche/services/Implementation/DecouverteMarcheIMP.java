package com.esprit.gestionmarche.services.Implementation;

import com.esprit.gestionmarche.persistence.entity.DecouverteMarche;
import com.esprit.gestionmarche.persistence.entity.OpportuniteMarche;
import com.esprit.gestionmarche.repositories.DecouverteMarcheRepository;
import com.esprit.gestionmarche.repositories.OpportuniteMarcheRepository;
import com.esprit.gestionmarche.services.Interface.DecouverteMarcheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class DecouverteMarcheIMP implements DecouverteMarcheService {

    @Autowired
    private DecouverteMarcheRepository Decrepository;

    @Autowired
    private OpportuniteMarcheRepository OppPrepository;

    @Override
    public DecouverteMarche save(DecouverteMarche decouverteMarche) {
        return Decrepository.save(decouverteMarche);
    }
    @Override
    public DecouverteMarche Update(DecouverteMarche decouverteMarche) {
        return Decrepository.save(decouverteMarche);
    }


    @Override
    public List<DecouverteMarche> findAll() {
        return  Decrepository.findAll();
    }

    @Override
    public DecouverteMarche findById(Integer id) {
        return Decrepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (Decrepository.existsById(id)) {
            Decrepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}