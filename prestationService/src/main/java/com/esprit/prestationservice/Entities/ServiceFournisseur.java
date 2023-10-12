package com.esprit.prestationservice.Entities;

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
public class ServiceFournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private String nomService;
    private String description;
    private Long nbLiked;
    private Long nbDisliked;
    private float prixService;
    @ManyToOne
    private User fournisseur;

    @OneToMany(mappedBy = "serviceFournisseur")
    private List<LikeService> likeServices;
}
