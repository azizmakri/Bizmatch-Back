package com.esprit.bizmatch_gestionevenement_conference.controllers;

import com.esprit.bizmatch_gestionevenement_conference.services.IConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/conference")
public class ConferenceController {
    IConferenceService iConferenceService;

}
