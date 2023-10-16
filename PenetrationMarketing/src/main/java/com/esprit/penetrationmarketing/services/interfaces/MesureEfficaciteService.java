package com.esprit.penetrationmarketing.services.interfaces;

import com.esprit.penetrationmarketing.persistence.entity.MesureEfficacite;

import java.util.List;

public interface MesureEfficaciteService {
    public MesureEfficacite save(MesureEfficacite mesureEfficacite);
    public MesureEfficacite Update(MesureEfficacite mesureEfficacite);

    public List<MesureEfficacite> findAll();
    public  MesureEfficacite findById(Long id);
    public boolean deleteById(Long id);
    public Double calculerROI(Long campagneId);


}
