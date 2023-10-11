package com.esprit.bizmatch_gestionreunion.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private Domaines Domaines;
    @Enumerated(EnumType.STRING)
    private RoleDemander roleDemander;
    private int isverified;
    private String verificationToken;
    private String location;
    private String aboutMe;
    private String siteWeb;
    private String facebook;
    private String linkedIn;


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


    //*********** A propos GestionEvenements+Conferences+ Gestion Reunions ***********//
    @OneToMany(mappedBy = "organisateur")
    private List<Evenement> evenementsCrees;
    @OneToMany(mappedBy = "organisateur")
    private List<Conference> conferencesCrees;
    @OneToMany(mappedBy = "user")
    private List<Participation> participations;
    @OneToMany(mappedBy = "organisateur")
    private List<Reunion> reunionsCrees;
    //***************************************************************//


}

