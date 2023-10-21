package com.esprit.prestationservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idRoom;
    private String roomName;

    @JsonIgnoreProperties(value = {"rooms"})
    @ManyToMany
    private List<User> users;

    @JsonIgnoreProperties(value = {"room"})
    @OneToMany(mappedBy = "room")
    private List<CommentRoom> commentRoomList;


    @JsonIgnore
    @ManyToOne
    private ServiceFournisseur serviceFournisseur;
}
