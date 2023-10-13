package com.esprit.decouvertemarche.persistence.entity;

import com.esprit.decouvertemarche.persistence.enumeration.Emojis;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Feedback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    @NotBlank(message = "Le champ commentaire ne doit pas être vide")
    private String commentaire;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private Emojis emojis;

    @ManyToOne
    @JoinColumn(name = "opportunite_id", nullable = false)
    private OpportuniteMarche opportuniteMarche;
}
