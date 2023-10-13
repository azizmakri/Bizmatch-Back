package com.esprit.developpementbusiness.persistence.entity;

import com.esprit.developpementbusiness.persistence.enumeration.TypeStrategie;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "StrategieMarketing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StrategieMarketing implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String titre; //Le nom ou le titre de la stratégie.

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String description; //Une description détaillée de la stratégie.

    @Temporal(TemporalType.DATE)
    private Date dateLancement; //La date à laquelle cette stratégie a été lancée ou mise en œuvre.

    @Enumerated(EnumType.STRING)
    private TypeStrategie type; // Le type de stratégie (digital, traditionnel, mixte).

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objectif_id")
    private ObjectifCommercial objectifCommercial; //L'objectif commercial associé à cette stratégie.



}

