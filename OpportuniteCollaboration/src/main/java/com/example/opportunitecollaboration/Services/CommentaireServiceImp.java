package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Entities.Commentaire;
import com.example.opportunitecollaboration.Repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImp implements CommentaireService{

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public Commentaire addCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire retrieveCommentaireById(Long idCommentaire) {
        return commentaireRepository.findById(idCommentaire).orElse(null);
    }

    @Override
    public List<Commentaire> retrieveAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public Boolean deleteCommentaire(Long idCommentaire) {
        if (commentaireRepository.existsById(idCommentaire)) {
            commentaireRepository.deleteById(idCommentaire);
            return true;
        }
        else {
            return false;
        }
    }
}
