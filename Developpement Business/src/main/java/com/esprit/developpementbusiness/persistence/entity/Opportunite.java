package com.esprit.developpementbusiness.persistence.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Opportunite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Opportunite implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "ce champ ne doit pas être vide")
    private String nom; //Le nom ou le titre de l'opportunité.

    private Double valeurPotentielle; //La valeur financière potentielle de cette opportunité.

    @Temporal(TemporalType.DATE)
    private Date dateIdentification; //La date à laquelle cette opportunité a été identifiée.


    @OneToMany(mappedBy = "opportunite", fetch = FetchType.LAZY)
    private List<Transaction> transactions; //Les transactions associées à cette opportunité.
}
