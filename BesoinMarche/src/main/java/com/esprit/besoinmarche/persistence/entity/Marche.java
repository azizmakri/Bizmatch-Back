package com.esprit.besoinmarche.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Marche")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class   Marche implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;


    @NotBlank(message = "Le nom ne doit pas être vide")
    @Size(max = 100, message = "Le nom doit avoir au maximum 100 caractères")
    private String nom;

    @NotNull(message = "La taille ne doit pas être nulle")
    @Min(value = 1, message = "La taille doit être supérieure à 0")
    private Integer taille;

    @NotNull(message = "La croissance prévue ne doit pas être nulle")
    private Double croissancePrevue;

    @NotNull(message = "La rentabilité ne doit pas être nulle")
    private Double rentabilite;

    private Double score;

    // Liste des critères associés à un marché
    @OneToMany(mappedBy = "marche", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Critere> criteres;
}


