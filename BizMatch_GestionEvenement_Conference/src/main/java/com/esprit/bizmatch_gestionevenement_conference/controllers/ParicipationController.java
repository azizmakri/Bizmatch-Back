package com.esprit.bizmatch_gestionevenement_conference.controllers;

import com.esprit.bizmatch_gestionevenement_conference.services.IParticipationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/evenement")
public class ParicipationController {

    IParticipationService iParticipationService;


    @PostMapping("/participate/{eventId}/{userName}")
    public String participateInEvent(@PathVariable Integer eventId, @PathVariable String userName) {
        return iParticipationService.participateInEvent(eventId, userName);
    }
}
