package com.esprit.penetrationmarketing.rest;

import com.esprit.penetrationmarketing.persistence.entity.MesureEfficacite;
import com.esprit.penetrationmarketing.services.interfaces.MesureEfficaciteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/marketing")
@AllArgsConstructor
public class MesureEfficaciteController {

    @Autowired
    private MesureEfficaciteService mesureEfficaciteService;

    @PostMapping("/mesure/add")
    public MesureEfficacite add(@RequestBody MesureEfficacite mesureEfficacite) {
        return mesureEfficaciteService.save(mesureEfficacite);
    }
    @PutMapping("/mesure/update")
    public MesureEfficacite Update(@RequestBody MesureEfficacite mesureEfficacite) {
        return	mesureEfficaciteService.Update(mesureEfficacite);
    }

    @GetMapping("/mesure/getAll")
    public List<MesureEfficacite> getAll() {
        return mesureEfficaciteService.findAll();
    }

    @GetMapping("/mesure/getById/{id}")
    public MesureEfficacite getById(@PathVariable Long id) {
        return mesureEfficaciteService.findById(id);
    }

    @DeleteMapping("/mesure/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return mesureEfficaciteService.deleteById(id);
    }
    @GetMapping("/mesure/roi/{campagneId}")
    public Double calculerROI(@PathVariable Long campagneId) {
        return mesureEfficaciteService.calculerROI(campagneId);
    }


}
