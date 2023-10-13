package com.esprit.decouvertemarche.rest;

import com.esprit.decouvertemarche.persistence.entity.Tendance;
import com.esprit.decouvertemarche.services.Interface.TendanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Marche")
@AllArgsConstructor
public class TendanceController {

    @Autowired
    private TendanceService service;

    @PostMapping("/tendance/add")
    public Tendance add(@RequestBody Tendance tendance) {
        return service.save(tendance);
    }
    @PutMapping("/tendance/update")
    public Tendance Update(@RequestBody Tendance tendance) {
        return	service.Update(tendance);
    }

    @GetMapping("/tendance/getAll")
    public List<Tendance> getAll() {
        return service.findAll();
    }

    @GetMapping("/tendance/getById/{id}")
    public Tendance getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/tendance/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
