package com.example.partenairespotentiels.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class OpportuniteCollaboration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpportuniteCollaboration;
    private String titreOpportuniteCollaboration;
    private String descriptionOpportuniteCollaboration;
    private Date datePublicationOpportuniteCollaboration;

    // Référence à la catégorie de cette opportunité de collaboration
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorieOpportuniteCollaboration;

    // Référence à l'utilisateur (auteur) de cette opportunité de collaboration
    @JsonIgnore
    @ManyToOne
    private User auteurOpportuniteCollaboration;

}


