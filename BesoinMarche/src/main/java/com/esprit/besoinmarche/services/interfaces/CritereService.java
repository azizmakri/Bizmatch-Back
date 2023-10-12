package com.esprit.besoinmarche.services.interfaces;

import com.esprit.besoinmarche.persistence.entity.Critere;

import java.util.List;

public interface CritereService {
    public Critere save(Critere critere);
    public Critere Update(Critere critere);

    public List<Critere> findAll();
    public  Critere findById(Long id);
    public boolean deleteById(Long id);
}
