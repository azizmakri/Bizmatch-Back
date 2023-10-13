package com.esprit.penetrationmarketing.services.interfaces;

import com.esprit.penetrationmarketing.persistence.entity.Contenu;

import java.util.List;

public interface ContenuService {
    public Contenu save(Contenu contenu);
    public Contenu Update(Contenu contenu);

    public List<Contenu> findAll();
    public  Contenu findById(Long id);
    public boolean deleteById(Long id);
}
