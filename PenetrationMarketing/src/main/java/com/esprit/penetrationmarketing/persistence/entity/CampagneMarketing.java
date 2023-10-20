package com.esprit.penetrationmarketing.persistence.entity;

import com.esprit.penetrationmarketing.persistence.enumeration.Devise;
import com.esprit.penetrationmarketing.persistence.enumeration.StatusCampagne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CampagneMarketing implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String nom;

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String description;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @NotNull
    private Double budget;

    @Enumerated(EnumType.STRING)
    private Devise devise;

    @Enumerated(EnumType.STRING)
    private StatusCampagne statut;

    @ManyToOne(fetch = FetchType.LAZY)
    private User entreprise;

    @OneToMany(mappedBy = "campagneMarketing", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"campagneMarketing"})
    private List<Contenu> contenus;

    @OneToMany(mappedBy = "campagneMarketing", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MesureEfficacite> mesuresEfficacite;
}