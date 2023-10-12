package com.esprit.bizmatch_gestionevenement_conference.entities;

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
@NoArgsConstructor
@AllArgsConstructor
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private String lieu;
    private Integer nombreParticipants;

    @JsonIgnore
    @OneToMany(mappedBy = "evenement")
    private List<Participation> participations;

    @JsonIgnore
    @OneToMany(mappedBy = "evenement")
    private List<Conference> conferences;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organisateur_id")
    private User organisateur; // Utilisateur qui a créé l'événement

}
