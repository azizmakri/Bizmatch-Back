package com.example.partenairespotentiels.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nomCategorie;
    private String descriptionCategorie;

    // Relation avec les articles de blog qui appartiennent à cette catégorie
    @JsonIgnore
    @OneToMany(mappedBy = "categorieArticleBlog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleBlog> articles;

    // Relation avec les articles de blog qui appartiennent à cette catégorie
    @JsonIgnore
    @OneToMany(mappedBy = "categorieOpportuniteCollaboration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpportuniteCollaboration> opportuniteCollaborations;

}


