package com.esprit.decouvertemarche.services.Implementation;

import com.esprit.decouvertemarche.persistence.entity.Tendance;
import com.esprit.decouvertemarche.repositories.TendanceRepository;
import com.esprit.decouvertemarche.services.Interface.TendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TendanceServiceIMP implements TendanceService {
    @Autowired
    private TendanceRepository TRepository;

    @Override
    public Tendance save(Tendance tendance) {
        return TRepository.save(tendance);
    }
    @Override
    public Tendance Update(Tendance tendance) {
        return TRepository.save(tendance);
    }


    @Override
    public List<Tendance> findAll() {
        return  TRepository.findAll();
    }

    @Override
    public Tendance findById(Long id) {
        return TRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (TRepository.existsById(id)) {
            TRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
