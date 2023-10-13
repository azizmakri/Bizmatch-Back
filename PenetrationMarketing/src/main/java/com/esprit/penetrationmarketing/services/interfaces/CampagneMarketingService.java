package com.esprit.penetrationmarketing.services.interfaces;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;

import java.util.Date;
import java.util.List;

public interface CampagneMarketingService {
    public CampagneMarketing save(CampagneMarketing campagneMarketing);
    public CampagneMarketing Update(CampagneMarketing campagneMarketing);

    public List<CampagneMarketing> findAll();
    public  CampagneMarketing findById(Long id);
    public boolean deleteById(Long id);
    public List<CampagneMarketing> getPerformanceByPeriod(Date startDate, Date endDate);
    public List<CampagneMarketing> getTopPerformingCampaigns(int limit);
}
