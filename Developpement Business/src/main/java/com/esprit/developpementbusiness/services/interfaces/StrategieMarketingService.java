package com.esprit.developpementbusiness.services.interfaces;

import com.esprit.developpementbusiness.persistence.entity.StrategieMarketing;

import java.util.List;

public interface StrategieMarketingService {
    public StrategieMarketing save(StrategieMarketing strategieMarketing);
    public StrategieMarketing Update(StrategieMarketing strategieMarketing);

    public List<StrategieMarketing> findAll();
    public  StrategieMarketing findById(Long id);
    public boolean deleteById(Long id);
}
