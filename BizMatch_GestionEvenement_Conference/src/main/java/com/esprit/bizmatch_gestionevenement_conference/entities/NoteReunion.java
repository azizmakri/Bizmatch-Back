package com.esprit.bizmatch_gestionevenement_conference.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteReunion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "reunion_id")
    private Reunion reunion;

}
