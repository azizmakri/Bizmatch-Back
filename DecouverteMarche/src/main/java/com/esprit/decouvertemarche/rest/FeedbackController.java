package com.esprit.decouvertemarche.rest;

import com.esprit.decouvertemarche.persistence.entity.Feedback;
import com.esprit.decouvertemarche.services.Interface.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Marche")
@AllArgsConstructor
public class FeedbackController {
    @Autowired
    private FeedbackService service;

    @PostMapping("/feedback/add")
    public Feedback add(@RequestBody Feedback feedback) {
        return service.save(feedback);
    }
    @PutMapping("/feedback/update")
    public Feedback Update(@RequestBody Feedback feedback) {
        return	service.Update(feedback);
    }

    @GetMapping("/feedback/getAll")
    public List<Feedback> getAll() {
        return service.findAll();
    }

    @GetMapping("/feedback/getById/{id}")
    public Feedback getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/feedback/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

}
