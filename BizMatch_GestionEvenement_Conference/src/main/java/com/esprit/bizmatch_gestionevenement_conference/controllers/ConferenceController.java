package com.esprit.bizmatch_gestionevenement_conference.controllers;

import com.esprit.bizmatch_gestionevenement_conference.entities.Conference;
import com.esprit.bizmatch_gestionevenement_conference.services.IConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/conference")
public class ConferenceController {
    IConferenceService iConferenceService;

    @PostMapping("/create/{username}")
    public Conference createConference(@PathVariable String username, @RequestBody Conference conference) {
        return iConferenceService.createConference(username, conference);
    }
    @GetMapping("/{id}")
    public Conference getConferenceById(@PathVariable Integer id) {
        return iConferenceService.getConferenceById(id);
    }


    @GetMapping("/all")
    public List<Conference> getAllConferences() {
        return iConferenceService.getAllConferences();
    }

    @PutMapping("/update/{username}/{conferenceId}")
    public Conference updateConference(
            @PathVariable String username,
            @PathVariable Integer conferenceId,
            @RequestBody Conference updatedConference
    ) {
        return iConferenceService.updateConference(username, conferenceId, updatedConference);
    }

    @DeleteMapping("/delete/{username}/{conferenceId}")
    public String deleteConference(
            @PathVariable String username,
            @PathVariable Integer conferenceId
    ) {
        iConferenceService.deleteConference(username, conferenceId);
        return "Conference deleted successfully";
    }

    @PostMapping("/addToEvent/{eventId}")
    public Conference addConferenceToEvent(
            @PathVariable Integer eventId,
            @RequestBody Conference conference
    ) {
        return iConferenceService.addConferenceToEvent(eventId, conference);
    }

}
