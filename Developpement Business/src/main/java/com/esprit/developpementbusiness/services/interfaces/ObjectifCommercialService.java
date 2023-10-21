package com.esprit.developpementbusiness.services.interfaces;

import com.esprit.developpementbusiness.persistence.entity.ObjectifCommercial;

import java.util.List;

public interface ObjectifCommercialService {
    public ObjectifCommercial save(ObjectifCommercial objectifCommercial);
    public ObjectifCommercial Update(ObjectifCommercial objectifCommercial);

    public List<ObjectifCommercial> findAll();
    public  ObjectifCommercial findById(Long id);
    public boolean deleteById(Long id);
}
