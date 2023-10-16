package com.esprit.decouvertemarche.persistence.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DecouverteMarche")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DecouverteMarche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String nom;  // Nom de la découverte
    private String description;  // Description de la découverte
    private Double taillePotentielle;  // Taille potentielle du marché
    private String localisation;  // Zone géographique concernée
    private String typeService;  // Type de produit ou service concerné


    @ManyToOne( fetch = FetchType.LAZY)
    private User utilisateur;
}
