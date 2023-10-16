package com.esprit.developpementbusiness.services.interfaces;

import com.esprit.developpementbusiness.persistence.entity.PerformanceCommerciale;

import java.util.List;

public interface PerformanceCommercialeService {
    public PerformanceCommerciale save(PerformanceCommerciale performanceCommerciale);
    public PerformanceCommerciale Update(PerformanceCommerciale performanceCommerciale);

    public List<PerformanceCommerciale> findAll();
    public  PerformanceCommerciale findById(Long id);
    public boolean deleteById(Long id);
}
