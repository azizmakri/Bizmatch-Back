package com.example.opportunitecollaboration.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;
    private String contenuCommentaire;
    private Date datePublicationCommentaire;

    // Relation Many-to-One avec l'article de blog associé
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleBlog articleBlog;

    // Référence à l'utilisateur qui a écrit ce commentaire
    @JsonIgnore
    @ManyToOne
    private User auteurCommentaire;
}

