package com.esprit.prestationservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private String nomService;
    private String description;
    private Long nbLiked;
    private Long nbDisliked;
    private float prixService;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @JsonIgnoreProperties(value = {"serviceFournisseurs"})
    @ManyToOne
    private User fournisseur;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceFournisseur")
    private List<LikeService> likeServices;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceFournisseur")
    private List<Room> rooms;

}
