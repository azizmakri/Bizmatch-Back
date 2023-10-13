package com.example.opportunitecollaboration.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleBlog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticleBlog;
    private String titreArticleBlog;
    private String contenuArticleBlog;
    private Date datePublicationArticleBlog;

    // Relation avec la catégorie de cet article de blog
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorieArticleBlog;

    // Relation avec les commentaires associés à cet article
    @JsonIgnore
    @OneToMany(mappedBy = "articleBlog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commentaire> commentairesArticleBlog;


    // Référence à l'utilisateur (auteur) de cet article de blog
    @JsonIgnore
    @ManyToOne
    private User auteurArticleBlog;

}


