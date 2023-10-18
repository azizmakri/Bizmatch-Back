package com.example.paymentms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikeService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLike;

    @JsonIgnore
    @ManyToOne
    private User entreprise;

    @JsonIgnore
    @ManyToOne
    private ServiceFournisseur serviceFournisseur;
}
