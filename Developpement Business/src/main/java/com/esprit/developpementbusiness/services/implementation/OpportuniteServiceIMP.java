package com.esprit.developpementbusiness.services.implementation;

import com.esprit.developpementbusiness.persistence.entity.Opportunite;
import com.esprit.developpementbusiness.repositories.OpportuniteRepository;
import com.esprit.developpementbusiness.services.interfaces.OpportuniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OpportuniteServiceIMP implements OpportuniteService {
    @Autowired
    private OpportuniteRepository opportuniteRepository;

    @Override
    public Opportunite save(Opportunite contenu) {
        return opportuniteRepository.save(contenu);
    }

    @Override
    public Opportunite Update(Opportunite contenu) {
        return opportuniteRepository.save(contenu);
    }

    @Override
    public List<Opportunite> findAll() {
        return opportuniteRepository.findAll();
    }

    @Override
    public Opportunite findById(Long id) {
        return opportuniteRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (opportuniteRepository.existsById(id)) {
            opportuniteRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
