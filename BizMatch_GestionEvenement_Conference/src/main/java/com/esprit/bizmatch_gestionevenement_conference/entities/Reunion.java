package com.esprit.bizmatch_gestionevenement_conference.entities;

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
public class Reunion  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String sujet;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private String lieu;

    @Enumerated(EnumType.STRING)
    private TypeReunion typeReunion;

    private String urlReunion;

    @OneToMany(mappedBy = "reunion")
    private List<NoteReunion> notesReunion;

    @ManyToOne
    @JoinColumn(name = "organisateur_id")
    private User organisateur; // Utilisateur qui a créé la réunion
}
