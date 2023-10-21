package com.example.partenairespotentiels.Services;

import com.example.partenairespotentiels.Entities.Discussion;
import com.example.partenairespotentiels.Entities.User;

import java.util.List;

public interface DiscussionService {
    List<Discussion> getAllDiscussions();
    Discussion getDiscussionById(Long id);
    Discussion createDiscussion(Discussion discussion);
    void deleteDiscussion(Long id);

}