package com.esprit.decouvertemarche.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

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
    private Long id;

    @NotEmpty(message = "Le champ nom ne doit pas être vide")
    private String nom;  // Nom de l'opportunité

    @NotEmpty(message = "Le champ description ne doit pas être vide")
    private String description;  // Description de l'opportunité

    private Double tailleMarche;  // Taille du marché
    private Double croissanceAttendue;  // Croissance attendue
    private Double rentabilite;  // Rentabilité
    private String segmentMarche;  // Segment de marché
    private String localisation;  // Zone géographique concernée
    private String typeService;  // Type de produit ou service concerné

    private Boolean accepte;

    @OneToMany(mappedBy = "opportuniteMarche", cascade = CascadeType.ALL)
    private List<Tendance> tendances;

    @OneToMany(mappedBy = "opportuniteMarche", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;


    @ManyToOne( fetch = FetchType.LAZY)
    private User entreprise;
}

