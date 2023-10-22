package com.example.partenairespotentiels.Services;


import com.example.partenairespotentiels.Entities.Discussion;
import com.example.partenairespotentiels.Entities.User;
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
    public void deleteDiscussion(Long id) {
        discussionRepository.deleteById(id);
    }


}