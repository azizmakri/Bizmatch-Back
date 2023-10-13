package com.example.partenairespotentiels.Services;

import com.example.partenairespotentiels.Entities.Discussion;

import java.util.List;

public interface DiscussionService {
    List<Discussion> getAllDiscussions();
    Discussion getDiscussionById(Long id);
    Discussion createDiscussion(Discussion discussion);
    Discussion updateDiscussion(Long id, Discussion discussion);
    void deleteDiscussion(Long id);
}