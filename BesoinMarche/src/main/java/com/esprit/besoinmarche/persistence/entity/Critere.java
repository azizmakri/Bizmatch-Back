package com.esprit.besoinmarche.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Critere")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Critere implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    @NotBlank(message = "Le nom ne doit pas être vide")
    @Size(max = 100, message = "Le nom doit avoir au maximum 100 caractères")
    private String nom;

    @NotBlank(message = "Le type ne doit pas être vide")
    @Size(max = 50, message = "Le type doit avoir au maximum 50 caractères")
    private String type;

    @Size(max = 255, message = "La description doit avoir au maximum 255 caractères")
    private String description;

    @NotNull
    private Double valeur;

    // Marché associé à un critère spécifique
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marche_id")
    private Marche marche;
}
