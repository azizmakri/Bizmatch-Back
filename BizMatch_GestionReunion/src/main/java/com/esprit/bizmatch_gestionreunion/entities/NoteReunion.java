package com.esprit.bizmatch_gestionreunion.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reunion_id")
    private Reunion reunion;

}
