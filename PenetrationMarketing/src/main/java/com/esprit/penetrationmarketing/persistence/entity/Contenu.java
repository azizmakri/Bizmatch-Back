package com.esprit.penetrationmarketing.persistence.entity;

import com.esprit.penetrationmarketing.persistence.enumeration.TypeContenu;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    private CampagneMarketing campagneMarketing;
}