package com.esprit.bizmatch_gestionreunion.controllers;

import com.esprit.bizmatch_gestionreunion.entities.NoteReunion;
import com.esprit.bizmatch_gestionreunion.entities.Reunion;
import com.esprit.bizmatch_gestionreunion.services.INoteReunionService;
import com.esprit.bizmatch_gestionreunion.services.IReunionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/reunion")
public class ReunionController {
private IReunionService iReunionService;
private INoteReunionService iNoteReunionService ;

    @PostMapping("/create/{username}")
    public Reunion createReunion(@PathVariable String username, @RequestBody Reunion reunion) {
        return iReunionService.createReunion(username, reunion);
    }


    @GetMapping("/{id}")
    public Reunion getReunionById(@PathVariable Integer id) {
        return iReunionService.getReunionById(id);
    }

    @GetMapping("/all")
    public List<Reunion> getAllReunions() {
        return iReunionService.getAllReunions();
    }

    @PutMapping("/update/{username}/{reunionId}")
    public Reunion updateReunion(
            @PathVariable String username,
            @PathVariable Integer reunionId,
            @RequestBody Reunion updatedReunion
    ) {
        return iReunionService.updateReunion(username, reunionId, updatedReunion);
    }

    @DeleteMapping("/delete/{username}/{reunionId}")
    public void deleteReunion(@PathVariable String username, @PathVariable Integer reunionId) {
        iReunionService.deleteReunion(username, reunionId);
    }

    @PostMapping("/{username}/{reunionId}")
    public void addNoteToReunion( @PathVariable String username,@PathVariable Integer reunionId, @RequestBody NoteReunion noteReunion) {
        iNoteReunionService.addNoteToReunion(username, reunionId, noteReunion);
    }

}
