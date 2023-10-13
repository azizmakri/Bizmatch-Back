package com.esprit.developpementbusiness.services.implementation;

import com.esprit.developpementbusiness.persistence.entity.StrategieMarketing;
import com.esprit.developpementbusiness.repositories.StrategieMarketingRepository;
import com.esprit.developpementbusiness.services.interfaces.StrategieMarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategieMarketingServiceIMP implements StrategieMarketingService {
    @Autowired
    private StrategieMarketingRepository strategieMarketingRepository;

    @Override
    public StrategieMarketing save( StrategieMarketing contenu) {
        return strategieMarketingRepository.save(contenu);
    }

    @Override
    public  StrategieMarketing Update( StrategieMarketing contenu) {
        return strategieMarketingRepository.save(contenu);
    }

    @Override
    public List<StrategieMarketing> findAll() {
        return strategieMarketingRepository.findAll();
    }

    @Override
    public StrategieMarketing findById(Long id) {
        return strategieMarketingRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (strategieMarketingRepository.existsById(id)) {
            strategieMarketingRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
