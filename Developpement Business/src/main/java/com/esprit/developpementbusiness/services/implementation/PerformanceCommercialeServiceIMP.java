package com.esprit.developpementbusiness.services.implementation;

import com.esprit.developpementbusiness.persistence.entity.PerformanceCommerciale;
import com.esprit.developpementbusiness.repositories.PerformanceCommercialeRepository;
import com.esprit.developpementbusiness.services.interfaces.PerformanceCommercialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerformanceCommercialeServiceIMP implements PerformanceCommercialeService {
    @Autowired
    private PerformanceCommercialeRepository performanceCommercialeRepository;

    @Override
    public PerformanceCommerciale save(PerformanceCommerciale performanceCommerciale) {
        return performanceCommercialeRepository.save(performanceCommerciale);
    }

    @Override
    public PerformanceCommerciale Update(PerformanceCommerciale performanceCommerciale) {
        return performanceCommercialeRepository.save(performanceCommerciale);
    }

    @Override
    public List<PerformanceCommerciale> findAll() {
        return performanceCommercialeRepository.findAll();
    }

    @Override
    public PerformanceCommerciale findById(Long id) {
        return performanceCommercialeRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (performanceCommercialeRepository.existsById(id)) {
            performanceCommercialeRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
