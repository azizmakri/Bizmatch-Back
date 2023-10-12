package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Repositories.OpportuniteCollaborationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportuniteCollaborationServiceImp implements OpportuniteCollaborationService{

    @Autowired
    OpportuniteCollaborationRepository opportuniteCollaborationRepository;

    @Override
    public OpportuniteCollaboration addOpportuniteCollaboration(OpportuniteCollaboration opportuniteCollaboration) {
        return opportuniteCollaborationRepository.save(opportuniteCollaboration);
    }

    @Override
    public OpportuniteCollaboration updateOpportuniteCollaboration(OpportuniteCollaboration opportuniteCollaboration) {
        return opportuniteCollaborationRepository.save(opportuniteCollaboration);
    }

    @Override
    public OpportuniteCollaboration retrieveOpportuniteCollaborationById(Long idOpportuniteCollaboration) {
        return opportuniteCollaborationRepository.findById(idOpportuniteCollaboration).orElse(null);
    }

    @Override
    public List<OpportuniteCollaboration> retrieveAllOpportunitesCollaboration() {
        return opportuniteCollaborationRepository.findAll();
    }

    @Override
    public Boolean deleteOpportuniteCollaboration(Long idOpportuniteCollaboration) {
        if (opportuniteCollaborationRepository.existsById(idOpportuniteCollaboration)) {
            opportuniteCollaborationRepository.deleteById(idOpportuniteCollaboration);
            return true;
        }
        else {
            return false;
        }
    }
}
