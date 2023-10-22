package com.esprit.developpementbusiness.rest;

import com.esprit.developpementbusiness.persistence.entity.StrategieMarketing;
import com.esprit.developpementbusiness.services.interfaces.StrategieMarketingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DevBusiness")
@AllArgsConstructor
public class StrategieMarketingController {
    @Autowired
    private StrategieMarketingService strategieService;

    @PostMapping("/strategie/add")
    public StrategieMarketing add(@RequestBody StrategieMarketing strategieMarketing) {
        return strategieService.save(strategieMarketing);
    }
    @PutMapping("/strategie/update")
    public StrategieMarketing Update(@RequestBody StrategieMarketing strategieMarketing) {
        return	strategieService.Update(strategieMarketing);
    }

    @GetMapping("/strategie/")
    public List<StrategieMarketing> getAll() {
        return strategieService.findAll();
    }

    @GetMapping("/strategie/{id}")
    public StrategieMarketing getById(@PathVariable Long id) {
        return strategieService.findById(id);
    }

    @DeleteMapping("/strategie/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return strategieService.deleteById(id);
    }
}
