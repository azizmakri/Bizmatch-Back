package com.example.partenairespotentiels.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discussion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiscussion;

    // Liste des participants à cette discussion (expéditeurs et destinataires)
    @JsonIgnore
    @ManyToMany
    private List<User> participantsDiscussion;

    // Liste des messages dans cette discussion
    @JsonIgnore
    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messagesDiscussion;

}

