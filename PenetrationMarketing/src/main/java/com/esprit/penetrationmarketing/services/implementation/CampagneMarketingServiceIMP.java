package com.esprit.penetrationmarketing.services.implementation;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import com.esprit.penetrationmarketing.repositories.CampagneMarketingRepository;
import com.esprit.penetrationmarketing.services.interfaces.CampagneMarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampagneMarketingServiceIMP implements CampagneMarketingService {

   @Autowired
   private CampagneMarketingRepository CMRepository;


    @Override
    public CampagneMarketing save(CampagneMarketing campagneMarketing) {
        return CMRepository.save(campagneMarketing);
    }

    @Override
    public CampagneMarketing Update(CampagneMarketing campagneMarketing) {
        return CMRepository.save(campagneMarketing);
    }

    @Override
    public List<CampagneMarketing> findAll() {
        return CMRepository.findAll();
    }

    @Override
    public CampagneMarketing findById(Long id) {
        return CMRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (CMRepository.existsById(id)) {
            CMRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
    @Override
    public List<CampagneMarketing> getPerformanceByPeriod(Date startDate, Date endDate) {
        return CMRepository.findByDateDebutBetween(startDate, endDate);
    }

    @Override
    public List<CampagneMarketing> getTopPerformingCampaigns(int limit) {
        List<CampagneMarketing> allCampaigns = CMRepository.findAll();
        return allCampaigns.stream()
                .sorted((c1, c2) -> Double.compare(c2.getBudget(), c1.getBudget())) // Replace with actual performance metric
                .limit(limit)
                .collect(Collectors.toList());
    }
}
