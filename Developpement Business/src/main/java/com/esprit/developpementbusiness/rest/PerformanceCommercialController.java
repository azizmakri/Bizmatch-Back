package com.esprit.developpementbusiness.rest;

import com.esprit.developpementbusiness.persistence.entity.PerformanceCommerciale;
import com.esprit.developpementbusiness.services.interfaces.PerformanceCommercialeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DevBusiness")
@AllArgsConstructor
public class PerformanceCommercialController {
    @Autowired
    private PerformanceCommercialeService performanceService;

    @PostMapping("/performance/add")
    public PerformanceCommerciale add(@RequestBody PerformanceCommerciale performanceCommerciale) {
        return performanceService.save(performanceCommerciale);
    }
    @PutMapping("/performance/update")
    public PerformanceCommerciale Update(@RequestBody PerformanceCommerciale performanceCommerciale) {
        return	performanceService.Update(performanceCommerciale);
    }

    @GetMapping("/performance/getAll")
    public List<PerformanceCommerciale> getAll() {
        return performanceService.findAll();
    }

    @GetMapping("/performance/getById/{id}")
    public PerformanceCommerciale getById(@PathVariable Long id) {
        return performanceService.findById(id);
    }

    @DeleteMapping("/performance/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return performanceService.deleteById(id);
    }
}
