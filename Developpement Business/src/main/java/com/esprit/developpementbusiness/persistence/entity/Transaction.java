package com.esprit.developpementbusiness.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private Double montant;  //Le montant de la transaction.

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTransaction; // La date à laquelle la transaction a eu lieu.




}
