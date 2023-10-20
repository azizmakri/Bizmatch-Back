package com.esprit.developpementbusiness.rest;

import com.esprit.developpementbusiness.persistence.entity.ObjectifCommercial;
import com.esprit.developpementbusiness.services.interfaces.ObjectifCommercialService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DevBusiness")
@AllArgsConstructor
public class ObjectifCommercialController {
    @Autowired
    private ObjectifCommercialService objectifService;

    @PostMapping("/objectif/add")
    public ObjectifCommercial add(@RequestBody ObjectifCommercial objectifCommercial) {
        return objectifService.save(objectifCommercial);
    }
    @PutMapping("/objectif/update")
    public ObjectifCommercial Update(@RequestBody ObjectifCommercial objectifCommercial) {
        return	objectifService.Update(objectifCommercial);
    }

    @GetMapping("/objectif/getAll")
    public List<ObjectifCommercial> getAll() {
        return objectifService.findAll();
    }

    @GetMapping("/objectif/getById/{id}")
    public ObjectifCommercial getById(@PathVariable Long id) {
        return objectifService.findById(id);
    }

    @DeleteMapping("/objectif/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return objectifService.deleteById(id);
    }
}
