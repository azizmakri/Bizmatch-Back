package com.esprit.developpementbusiness.persistence.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PerformanceCommerciale")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PerformanceCommerciale implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private Double chiffreAffaire; //Le chiffre d'affaires généré pendant une période donnée.

    private Double tauxConversion; //Le taux de conversion des leads en transactions.

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEvaluation; //La date à laquelle cette performance a été évaluée ou enregistrée.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprise_id")
    private User entreprise;

}
