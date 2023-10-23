package com.esprit.decouvertemarche.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Tendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Tendance implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    @NotBlank(message = "Le champ nom ne doit pas être vide")
    private String nom;

    @NotBlank(message = "Le champ description ne doit pas être vide")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateIdentification;

    @ManyToOne
    @JoinColumn(name = "opportunite_id", nullable = false)
    @JsonIgnoreProperties(value = {"tendances"})
    @JsonIgnore
    private OpportuniteMarche opportuniteMarche;
}

