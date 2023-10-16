package com.esprit.penetrationmarketing.rest;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import com.esprit.penetrationmarketing.services.interfaces.CampagneMarketingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/marketing")
@AllArgsConstructor
public class CampagneMarketingController {
    @Autowired
    private CampagneMarketingService campagneMarketingService;

    @PostMapping("/campagne/add")
    public CampagneMarketing add(@RequestBody CampagneMarketing campagneMarketing) {
        return campagneMarketingService.save(campagneMarketing);
    }
    @PutMapping("/campagne/update")
    public CampagneMarketing Update(@RequestBody CampagneMarketing campagneMarketing) {
        return	campagneMarketingService.Update(campagneMarketing);
    }

    @GetMapping("/campagne/getAll")
    public List<CampagneMarketing> getAll() {
        return campagneMarketingService.findAll();
    }

    @GetMapping("/campagne/getById/{id}")
    public CampagneMarketing getById(@PathVariable Long id) {
        return campagneMarketingService.findById(id);
    }

    @DeleteMapping("/campagne/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return campagneMarketingService.deleteById(id);
    }

    @GetMapping("/campagne/performance/{startDate}/{endDate}")
    public List<CampagneMarketing> getPerformanceByPeriod(
            @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return campagneMarketingService.getPerformanceByPeriod(startDate, endDate);
    }

    @GetMapping("/campagne/top-performing/{limit}")
    public List<CampagneMarketing> getTopPerformingCampaigns(@PathVariable int limit) {
        return campagneMarketingService.getTopPerformingCampaigns(limit);
    }

}
