package com.example.paymentms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private long amount;
    private long quantity;
    @CreationTimestamp
    private Date date;
    private String paymentStatus;

    private String currency;
    @Transient
    private String successUrl;
    @Transient
    private String cancelUrl;

    private String email;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "service_fournisseur_id")
    private ServiceFournisseur serviceFournisseur;





}