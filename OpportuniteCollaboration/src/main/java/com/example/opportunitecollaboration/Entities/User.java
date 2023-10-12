package com.example.opportunitecollaboration.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NotBlank(message = "Ce champ est obligatoire")
    @Size(min = 3, message = "Ce champs doit contenir au moins 3 caractères")
    private String userName;
    @NotBlank(message = "Ce champ est obligatoire")
    @Size(min = 3, message = "Ce champs doit contenir au moins 3 caractères")
    @NotNull
    private String userFirstName;
    @NotBlank(message = "Ce champ est obligatoire")
    @Size(min = 3, message = "Ce champs doit contenir au moins 3 caractères")
    @NotNull
    private String userLastName;
    private String userPassword;
    @Pattern(regexp = "[0-9]{8}", message = "Le numéro doit être composé de 8 chiffres")
    private String userNumber;
    private String userCode;
    @Email
    private String userEmail;
    private int isverified;
    private String verificationToken;
    @Enumerated(EnumType.STRING)
    private RoleDemander roleDemander;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;
    private String location;
    private String aboutMe;
    private String siteWeb;
    private String facebook;
    private String linkedIn;

    @Enumerated(EnumType.STRING)
    private Domaines Domaines;


//************attributs ahmed***************
    // Liste des discussions auxquelles cet utilisateur participe en tant qu'expéditeur ou destinataire
    @JsonIgnore
    @ManyToMany(mappedBy = "participantsDiscussion", cascade = CascadeType.ALL)
    private List<Discussion> discussions;

    // Liste des articles de blog écrits par cet utilisateur
    @JsonIgnore
    @OneToMany(mappedBy = "auteurArticleBlog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleBlog> articlesBlog;

    // Liste des opportunités de collaboration publiées par cet utilisateur
    @JsonIgnore
    @OneToMany(mappedBy = "auteurOpportuniteCollaboration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpportuniteCollaboration> opportunitesCollaboration;

    // Liste des commentaire publiées par cet utilisateur
    @JsonIgnore
    @OneToMany(mappedBy = "auteurCommentaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commentaire> commentaires;

    @Enumerated(EnumType.STRING)
    private TypeEntreprise typeEntreprise;


//************attributs ahmed***************

}
