package com.esprit.besoinmarche.services.interfaces;

import com.esprit.besoinmarche.persistence.entity.Besoin;

import java.util.List;

public interface BesoinService {
    public Besoin save(Besoin besoin);
    public Besoin Update(Besoin besoin);

    public List<Besoin> findAll();
    public  Besoin findById(Long id);
    public boolean deleteById(Long id);
    public List<Besoin> getBesoinByType(String type);
}
