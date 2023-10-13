package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Entities.OpportuniteCollaboration;

import java.util.List;

public interface OpportuniteCollaborationService {

    OpportuniteCollaboration addOpportuniteCollaboration(OpportuniteCollaboration opportuniteCollaboration);
    OpportuniteCollaboration updateOpportuniteCollaboration(OpportuniteCollaboration opportuniteCollaboration);
    OpportuniteCollaboration retrieveOpportuniteCollaborationById(Long idOpportuniteCollaboration);
    List<OpportuniteCollaboration> retrieveAllOpportunitesCollaboration();
    Boolean deleteOpportuniteCollaboration(Long idOpportuniteCollaboration);
}
