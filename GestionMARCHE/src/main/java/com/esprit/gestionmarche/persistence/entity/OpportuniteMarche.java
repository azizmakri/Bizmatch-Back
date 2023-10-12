package com.esprit.gestionmarche.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OpportuniteMarche")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OpportuniteMarche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private String nom;  // Nom de l'opportunité
    private String description;  // Description de l'opportunité
    private Double tailleMarche;  // Taille du marché
    private Double croissanceAttendue;  // Croissance attendue
    private Double rentabilite;  // Rentabilité
    private String segmentMarche;  // Segment de marché
    private String localisation;  // Zone géographique concernée
    private String typeService;  // Type de produit ou service concerné
    private Boolean accepte;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private DecouverteMarche decouverteMarche;  // Lien vers l'entité parente 'DecouverteMarche'
}

