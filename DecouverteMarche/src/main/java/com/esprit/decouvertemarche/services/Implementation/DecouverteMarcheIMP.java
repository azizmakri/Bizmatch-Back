package com.esprit.decouvertemarche.services.Implementation;

import com.esprit.decouvertemarche.persistence.entity.DecouverteMarche;
import com.esprit.decouvertemarche.repositories.DecouverteMarcheRepository;
import com.esprit.decouvertemarche.repositories.OpportuniteMarcheRepository;
import com.esprit.decouvertemarche.services.Interface.DecouverteMarcheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public DecouverteMarche findById(Long id) {
        return Decrepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (Decrepository.existsById(id)) {
            Decrepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}