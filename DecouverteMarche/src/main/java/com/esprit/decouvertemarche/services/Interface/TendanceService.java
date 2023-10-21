package com.esprit.decouvertemarche.services.Interface;

import com.esprit.decouvertemarche.persistence.entity.Tendance;

import java.util.List;

public interface TendanceService {
    public Tendance save(Tendance tendance);
    public Tendance Update(Tendance tendance);

    public List<Tendance> findAll();
    public  Tendance findById(Long id);
    public boolean deleteById(Long id);
}
