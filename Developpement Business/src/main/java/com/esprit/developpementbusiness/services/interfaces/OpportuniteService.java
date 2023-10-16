package com.esprit.developpementbusiness.services.interfaces;

import com.esprit.developpementbusiness.persistence.entity.Opportunite;

import java.util.List;

public interface OpportuniteService {
    public Opportunite save(Opportunite opportunite);
    public Opportunite Update(Opportunite opportunite);

    public List<Opportunite> findAll();
    public  Opportunite findById(Long id);
    public boolean deleteById(Long id);
}
