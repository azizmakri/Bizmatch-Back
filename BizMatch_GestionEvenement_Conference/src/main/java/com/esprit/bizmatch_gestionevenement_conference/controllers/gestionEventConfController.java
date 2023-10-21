package com.esprit.bizmatch_gestionevenement_conference.controllers;

import com.esprit.bizmatch_gestionevenement_conference.entities.Conference;
import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.services.IConferenceService;
import com.esprit.bizmatch_gestionevenement_conference.services.IEvenementService;
import com.esprit.bizmatch_gestionevenement_conference.services.IParticipationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/gestionEventConf")
public class gestionEventConfController {

    IEvenementService iEvenementService;
    IConferenceService iConferenceService;
    IParticipationService iParticipationService;

    //************************** Evenement Methods **********************************//

   /* @PostMapping("/createEvent/{userName}")
    public Evenement createEvenement(@RequestBody Evenement evenement, @PathVariable String userName) {
        return iEvenementService.createEvenement(evenement,userName);
    }*/


    @PostMapping("/createEvent")
    public ResponseEntity<Evenement> createEvenement(
            @RequestParam String nom,
            @RequestParam String description,
            @RequestParam Date dateDebut,
            @RequestParam Date dateFin,
            @RequestParam MultipartFile image,
            @RequestParam String lieu,
            @RequestParam Integer nombreParticipants,
            @RequestParam String userName
    ) {
        try {
            Evenement evenement = iEvenementService.addEvenement(
                    nom, description, dateDebut, dateFin, image, lieu, nombreParticipants, userName
            );
            return new ResponseEntity<>(evenement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEvent/{eventId}/{userName}")
    public ResponseEntity<Evenement> updateEvenement(
            @PathVariable Integer eventId,
            @RequestParam String nom,
            @RequestParam String description,
            @RequestParam Date dateDebut,
            @RequestParam Date dateFin,
            @RequestParam MultipartFile image,
            @RequestParam String lieu,
            @RequestParam Integer nombreParticipants,
            @PathVariable String userName
    ) {
        try {
            Evenement evenement = new Evenement();
            evenement.setId(eventId); // Définir l'ID de l'événement à mettre à jour
            evenement.setNom(nom);
            evenement.setDescription(description);
            evenement.setDateDebut(dateDebut);
            evenement.setDateFin(dateFin);
            evenement.setLieu(lieu);
            evenement.setNombreParticipants(nombreParticipants);

            Evenement updatedEvenement = iEvenementService.updateEvenement(eventId, nom, description, dateDebut, dateFin, image, lieu, nombreParticipants, userName);
            return new ResponseEntity<>(updatedEvenement, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    /*@PutMapping("/updateEvent/{userName}")
    public Evenement updateEvenement(@RequestBody Evenement evenement, @PathVariable String userName) {
        return iEvenementService.updateEvenement(evenement, userName);
    }*/

    @DeleteMapping("/deleteEvent/{idEvent}/{userName}")
    public void deleteEvenement(@PathVariable Integer idEvent, @PathVariable String userName) {
        iEvenementService.deleteEvenement(idEvent, userName);
    }

    @GetMapping("/getEvent/{idEvent}")
    public Evenement getEvenementById(@PathVariable Integer idEvent) {
        return iEvenementService.getEvenementById(idEvent);
    }

    @GetMapping("/getAllEvents")
    public List<Evenement> getAllEvents(){
        return iEvenementService.getAllEvenements();
    }
    @GetMapping("/allEvents/{userName}")
    public List<Evenement> getAllEvenementsByUserId(@PathVariable String userName) {
        return iEvenementService.getAllEvenementsByUserId(userName);
    }

    ///************************End-Evenement-Section *************************************//

    //************************ Participation Methods ***********************************//
        @PostMapping("/participate/{eventId}/{userName}")
        public String participateInEvent(@PathVariable Integer eventId, @PathVariable String userName) {
            return iParticipationService.participateInEvent(eventId, userName);
        }
    //************************ End-Participation-Section *********************//

    //************************ Favoris Evenement *****************************//
    @GetMapping("/favoris/{username}")
    public List<Evenement> getEvenementsFavorisByuserName(@PathVariable String username) {
        return iEvenementService.getEvenementsFavoris(username);
    }

    @PostMapping("/favoris/{username}/{idEvent}")
    public void ajouterEvenementFavori(@PathVariable String username, @PathVariable Integer idEvent) {
        iEvenementService.addFavoriEvenement(username, idEvent);
    }
    //************************ End ******************************************//

    //************************  Conference Methods ***************************//

    @PostMapping("/createConf/{username}")
    public Conference createConference(@PathVariable String username, @RequestBody Conference conference) {
        return iConferenceService.createConference(username, conference);
    }
    @GetMapping("/getConf/{id}")
    public Conference getConferenceById(@PathVariable Integer id) {
        return iConferenceService.getConferenceById(id);
    }


    @GetMapping("/allConf")
    public List<Conference> getAllConferences() {
        return iConferenceService.getAllConferences();
    }

    @PutMapping("/updateConf/{username}/{conferenceId}")
    public Conference updateConference(
            @PathVariable String username,
            @PathVariable Integer conferenceId,
            @RequestBody Conference updatedConference
    ) {
        return iConferenceService.updateConference(username, conferenceId, updatedConference);
    }

    @DeleteMapping("/deleteConf/{username}/{conferenceId}")
    public String deleteConference(
            @PathVariable String username,
            @PathVariable Integer conferenceId
    ) {
        iConferenceService.deleteConference(username, conferenceId);
        return "Conference deleted successfully";
    }

    @PostMapping("/addConfToEvent/{eventId}")
    public Conference addConferenceToEvent(
            @PathVariable Integer eventId,
            @RequestBody Conference conference
    ) {
        return iConferenceService.addConferenceToEvent(eventId, conference);
    }


    //************************ End-Conference-Section *********************//

}
