package com.esprit.bizmatch_gestionreunion.services;

import com.esprit.bizmatch_gestionreunion.entities.NoteReunion;

public interface INoteReunionService {
    public NoteReunion addNoteToReunion(String username, Integer reunionId, NoteReunion noteReunion) ;

    }
