package com.esprit.besoinmarche.services.implementation;

import com.esprit.besoinmarche.persistence.entity.Besoin;
import com.esprit.besoinmarche.persistence.enumeration.TypeBesoin;
import com.esprit.besoinmarche.repositories.BesoinRepository;
import com.esprit.besoinmarche.services.interfaces.BesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BesoinServiceIMP implements BesoinService {
    @Autowired
    private BesoinRepository besoinRepository;

    @Override
    public Besoin save(Besoin contenu) {
        return besoinRepository.save(contenu);
    }

    @Override
    public Besoin Update(Besoin contenu) {
        return besoinRepository.save(contenu);
    }

    @Override
    public List<Besoin> findAll() {
        return besoinRepository.findAll();
    }

    @Override
    public Besoin findById(Long id) {
        return besoinRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (besoinRepository.existsById(id)) {
            besoinRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
    @Override
    public List<Besoin> getBesoinByType(String type) {
        TypeBesoin typeBesoin = TypeBesoin.valueOf(type.toUpperCase());
        return besoinRepository.findByType(typeBesoin);
    }
}
