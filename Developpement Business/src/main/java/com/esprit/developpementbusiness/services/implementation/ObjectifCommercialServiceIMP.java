package com.esprit.developpementbusiness.services.implementation;

import com.esprit.developpementbusiness.persistence.entity.ObjectifCommercial;
import com.esprit.developpementbusiness.repositories.ObjectifCommercialRepository;
import com.esprit.developpementbusiness.services.interfaces.ObjectifCommercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectifCommercialServiceIMP implements ObjectifCommercialService {
    @Autowired
    private ObjectifCommercialRepository objectifCommercialRepository;

    @Override
    public ObjectifCommercial save(ObjectifCommercial objectifCommercial) {
        return objectifCommercialRepository.save(objectifCommercial);
    }

    @Override
    public ObjectifCommercial Update(ObjectifCommercial objectifCommercial) {
        return objectifCommercialRepository.save(objectifCommercial);
    }

    @Override
    public List<ObjectifCommercial> findAll() {
        return objectifCommercialRepository.findAll();
    }

    @Override
    public ObjectifCommercial findById(Long id) {
        return objectifCommercialRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (objectifCommercialRepository.existsById(id)) {
            objectifCommercialRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
