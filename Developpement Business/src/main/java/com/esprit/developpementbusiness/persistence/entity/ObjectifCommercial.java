package com.esprit.developpementbusiness.persistence.entity;

import com.esprit.developpementbusiness.persistence.enumeration.EtatObjectif;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "ObjectifCommercial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ObjectifCommercial implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String titre; //Le nom ou le titre de l'objectif.

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String description; //Une description détaillée de l'objectif.

    private Double cibleFinanciere; //La cible financière ou le montant que l'entreprise souhaite atteindre avec cet objectif.

    @Temporal(TemporalType.DATE)
    private Date dateDebut;
// La période pendant laquelle cet objectif est actif.
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Enumerated(EnumType.STRING)
    private EtatObjectif etat; //L'état actuel de l'objectif (en cours, atteint, non atteint).

    @ManyToOne( fetch = FetchType.LAZY)
    private User entreprise;

    @OneToMany(mappedBy = "objectifCommercial", fetch = FetchType.LAZY)
    private List<StrategieMarketing> strategies; // Les différentes stratégies marketing associées à cet objectif.
}

