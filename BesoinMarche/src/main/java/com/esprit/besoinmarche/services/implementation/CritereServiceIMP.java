package com.esprit.besoinmarche.services.implementation;

import com.esprit.besoinmarche.persistence.entity.Critere;
import com.esprit.besoinmarche.repositories.CritereRepository;
import com.esprit.besoinmarche.services.interfaces.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CritereServiceIMP implements CritereService {
    @Autowired
    private CritereRepository critereRepository;

    @Override
    public Critere save(Critere critere) {
        return critereRepository.save(critere);
    }

    @Override
    public Critere Update(Critere critere) {
        return critereRepository.save(critere);
    }

    @Override
    public List<Critere> findAll() {
        return critereRepository.findAll();
    }

    @Override
    public Critere findById(Long id) {
        return critereRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (critereRepository.existsById(id)) {
            critereRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
