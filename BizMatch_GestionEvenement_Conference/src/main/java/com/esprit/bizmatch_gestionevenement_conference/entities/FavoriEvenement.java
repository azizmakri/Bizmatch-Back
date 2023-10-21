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
@AllArgsConstructor
@NoArgsConstructor
public class FavoriEvenement implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idFavori ;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Evenement evenement;

    private Date dateAjout;

//    public FavoriProduct(User user, Product product, Date dateAjout) {
//        this.user = user;
//        this.product = product;
//        this.dateAjout = dateAjout;
//    }
}