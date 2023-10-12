package com.esprit.gestionmarche.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    private Integer id;

    private String nom;  // Nom de la découverte
    private String description;  // Description de la découverte
    private Double taillePotentielle;  // Taille potentielle du marché
    private String tendances;  // Tendances du marché
    private String opportunites;  // Opportunités identifiées
    private String localisation;  // Zone géographique concernée
    private String typeService;  // Type de produit ou service concerné

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "decouverteMarche")
    private List<OpportuniteMarche> opportunitesMarche;  // Liste des opportunités liées à cette découverte
}
