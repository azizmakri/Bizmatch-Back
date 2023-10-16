package com.esprit.penetrationmarketing.services.implementation;

import com.esprit.penetrationmarketing.persistence.entity.Contenu;
import com.esprit.penetrationmarketing.repositories.ContenuRepository;
import com.esprit.penetrationmarketing.services.interfaces.ContenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContenuServiceIMP implements ContenuService {
    @Autowired
    private ContenuRepository ContenuRepository;

    @Override
    public Contenu save(Contenu contenu) {
        return ContenuRepository.save(contenu);
    }

    @Override
    public Contenu Update(Contenu contenu) {
        return ContenuRepository.save(contenu);
    }

    @Override
    public List<Contenu> findAll() {
        return ContenuRepository.findAll();
    }

    @Override
    public Contenu findById(Long id) {
        return ContenuRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (ContenuRepository.existsById(id)) {
            ContenuRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
