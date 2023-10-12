package com.esprit.besoinmarche.rest;

import com.esprit.besoinmarche.persistence.entity.Besoin;
import com.esprit.besoinmarche.services.interfaces.BesoinService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/besoinMarche")
@AllArgsConstructor
public class BesoinController {
    @Autowired
    private BesoinService besoinService;

    @PostMapping("/besoin/add")
    public Besoin add(@RequestBody Besoin besoin) {
        return besoinService.save(besoin);
    }
    @PutMapping("/besoin/update")
    public Besoin Update(@RequestBody Besoin besoin) {
        return	besoinService.Update(besoin);
    }

    @GetMapping("/besoin/getAll")
    public List<Besoin> getAll() {
        return besoinService.findAll();
    }

    @GetMapping("/besoin/getById/{id}")
    public Besoin getById(@PathVariable Long id) {
        return besoinService.findById(id);
    }

    @DeleteMapping("/besoin/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return besoinService.deleteById(id);
    }

    @GetMapping("/besoin/type/{type}")
    public ResponseEntity<List<Besoin>> getBesoinByType(@PathVariable String type) {
        try {
            List<Besoin> besoins = besoinService.getBesoinByType(type);
            return new ResponseEntity<>(besoins, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
