package com.esprit.penetrationmarketing.persistence.entity;

import com.esprit.penetrationmarketing.persistence.enumeration.TypeContenu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contenu implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeContenu type;

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String titre;

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String description;

    private String lien;

    private String image;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonIgnoreProperties(value = {"contenus"})
    private CampagneMarketing campagneMarketing;
}