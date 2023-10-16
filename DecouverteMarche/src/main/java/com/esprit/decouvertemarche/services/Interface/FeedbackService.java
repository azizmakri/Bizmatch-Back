package com.esprit.decouvertemarche.services.Interface;

import com.esprit.decouvertemarche.persistence.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    public Feedback save(Feedback feedback);
    public Feedback Update(Feedback feedback);

    public List<Feedback> findAll();
    public  Feedback findById(Long id);
    public boolean deleteById(Long id);

}
