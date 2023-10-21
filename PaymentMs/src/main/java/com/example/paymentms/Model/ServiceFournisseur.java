package com.example.paymentms.Model;

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
    @JsonIgnore
    @ManyToOne
    private User fournisseur;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceFournisseur")
    private List<LikeService> likeServices;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceFournisseur", cascade = CascadeType.ALL)
    private List<Payment> payments;
}
