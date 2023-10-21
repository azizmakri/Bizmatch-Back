package com.esprit.decouvertemarche.services.Implementation;

import com.esprit.decouvertemarche.persistence.entity.Feedback;
import com.esprit.decouvertemarche.repositories.FeedbackRepository;
import com.esprit.decouvertemarche.services.Interface.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceIMP  implements FeedbackService {
    @Autowired
    private FeedbackRepository FRepository;

    @Override
    public Feedback save(Feedback feedback) {
        return FRepository.save(feedback);
    }
    @Override
    public Feedback Update(Feedback feedback) {
        return FRepository.save(feedback);
    }


    @Override
    public List<Feedback> findAll() {
        return  FRepository.findAll();
    }

    @Override
    public Feedback findById(Long id) {
        return FRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (FRepository.existsById(id)) {
            FRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
