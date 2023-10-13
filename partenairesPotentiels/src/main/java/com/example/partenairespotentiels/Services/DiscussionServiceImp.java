package com.example.partenairespotentiels.Services;


import com.example.partenairespotentiels.Entities.Discussion;
import com.example.partenairespotentiels.Repositories.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionServiceImp implements DiscussionService {

    @Autowired
    DiscussionRepository discussionRepository;


    @Override
    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    @Override
    public Discussion getDiscussionById(Long id) {
        return discussionRepository.findById(id).orElse(null);
    }

    @Override
    public Discussion createDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    @Override
    public Discussion updateDiscussion(Long id, Discussion discussion) {
        Discussion existingDiscussion = discussionRepository.findById(id).orElse(null);
        if (existingDiscussion != null) {
            // Update properties of the existing discussion with the new discussion
            // You can add logic here to update specific properties as needed
            existingDiscussion.setParticipantsDiscussion(discussion.getParticipantsDiscussion());
            existingDiscussion.setMessagesDiscussion(discussion.getMessagesDiscussion());

            return discussionRepository.save(existingDiscussion);
        }
        return null; // Discussion not found
    }

    @Override
    public void deleteDiscussion(Long id) {
        discussionRepository.deleteById(id);
    }
}