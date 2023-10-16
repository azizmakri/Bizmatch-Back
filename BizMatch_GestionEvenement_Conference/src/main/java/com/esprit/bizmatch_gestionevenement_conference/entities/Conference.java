package com.esprit.bizmatch_gestionevenement_conference.entities;

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
@NoArgsConstructor
@AllArgsConstructor
public class Conference implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String titre;

    private String theme;

    private String description;

    @Enumerated(EnumType.STRING)
    private TypeConference typeConference;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organisateur_id")
    private User organisateur; // Utilisateur qui a créé la conférence

}
