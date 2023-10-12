package com.esprit.besoinmarche.persistence.entity;


import com.esprit.besoinmarche.persistence.enumeration.TypeBesoin;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Besoin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Besoin implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    @NotBlank(message = "La description ne doit pas être vide")
    @Size(max = 255, message = "La description doit avoir au maximum 255 caractères")
    private String description;

    @Enumerated(EnumType.STRING)
    private TypeBesoin type;


    // Entreprise associée à un besoin spécifique
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprise_id")
    private User entreprise;
}

