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
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    private String contenuMessage;
    private Date dateEnvoiMessage;

    // Référence à la discussion à laquelle appartient ce message
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    // Référence à l'utilisateur qui a envoyé ce message
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User utilisateur;
}

