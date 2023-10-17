package com.esprit.bizmatch_gestionevenement_conference.controllers;

import com.esprit.bizmatch_gestionevenement_conference.entities.Conference;
import com.esprit.bizmatch_gestionevenement_conference.entities.Evenement;
import com.esprit.bizmatch_gestionevenement_conference.services.IConferenceService;
import com.esprit.bizmatch_gestionevenement_conference.services.IEvenementService;
import com.esprit.bizmatch_gestionevenement_conference.services.IParticipationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/gestionEventConf")
public class gestionEventConfController {

    IEvenementService iEvenementService;
    IConferenceService iConferenceService;
    IParticipationService iParticipationService;

    //************************** Evenement Methods **********************************//
    @PostMapping("/createEvent/{userName}")
    public Evenement createEvenement(@RequestBody Evenement evenement, @PathVariable String userName) {
        return iEvenementService.createEvenement(evenement,userName);
    }

    @PutMapping("/updateEvent/{userName}")
    public Evenement updateEvenement(@RequestBody Evenement evenement, @PathVariable String userName) {
        return iEvenementService.updateEvenement(evenement, userName);
    }

    @DeleteMapping("/deleteEvent/{idEvent}/{userName}")
    public void deleteEvenement(@PathVariable Integer idEvent, @PathVariable String userName) {
        iEvenementService.deleteEvenement(idEvent, userName);
    }

    @GetMapping("/getEvent/{idEvent}/{userName}")
    public Evenement getEvenementById(@PathVariable Integer idEvent, @PathVariable String userName) {
        return iEvenementService.getEvenementById(idEvent, userName);
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
