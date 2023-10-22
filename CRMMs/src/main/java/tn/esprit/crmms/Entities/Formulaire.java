package tn.esprit.CRMMs.Entities;


import lombok.*;
import tn.esprit.CRMMs.Entities.enums.ServiceType;
import tn.esprit.CRMMs.Entities.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode

public class Formulaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceType service;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OUVERT;

    private LocalDateTime date = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
