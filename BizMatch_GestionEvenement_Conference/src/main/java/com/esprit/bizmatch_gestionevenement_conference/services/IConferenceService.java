package com.esprit.bizmatch_gestionevenement_conference.services;

import com.esprit.bizmatch_gestionevenement_conference.entities.Conference;

import java.util.List;

public interface IConferenceService {
    public Conference createConference(String username, Conference conference);
    Conference getConferenceById(Integer id);
    List<Conference> getAllConferences();
    public Conference updateConference(String username, Integer conferenceId, Conference updatedConference);
    public void deleteConference(String username, Integer conferenceId) ;
    public Conference addConferenceToEvent(Integer eventId, Conference conference) ;

    }
