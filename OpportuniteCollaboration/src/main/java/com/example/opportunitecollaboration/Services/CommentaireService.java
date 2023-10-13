package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Entities.Commentaire;

import java.util.List;

public interface CommentaireService {

    Commentaire addCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Commentaire commentaire);
    Commentaire retrieveCommentaireById(Long idCommentaire);
    List<Commentaire> retrieveAllCommentaires();
    Boolean deleteCommentaire(Long idCommentaire);
}
