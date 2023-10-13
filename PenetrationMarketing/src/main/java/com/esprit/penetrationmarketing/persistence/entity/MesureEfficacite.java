package com.esprit.penetrationmarketing.persistence.entity;

import com.esprit.penetrationmarketing.persistence.enumeration.TypeMesure;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MesureEfficacite implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeMesure typeMesure;

    @NotNull
    private Double valeur;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMesure;

    @ManyToOne(fetch = FetchType.LAZY)
    private CampagneMarketing campagneMarketing;
}