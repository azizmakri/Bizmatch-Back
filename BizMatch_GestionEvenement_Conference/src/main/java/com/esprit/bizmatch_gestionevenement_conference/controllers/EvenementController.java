package com.esprit.bizmatch_gestionevenement_conference.controllers;

import com.esprit.bizmatch_gestionevenement_conference.services.IEvenementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/evenement")
public class EvenementController {
    IEvenementService iEvenementService;
}
