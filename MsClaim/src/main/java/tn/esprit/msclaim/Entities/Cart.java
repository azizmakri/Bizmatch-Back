package tn.esprit.msclaim.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Cart implements Serializable {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long idCart;
        private float totalCartPrice;
        private String topic;
        private int quantity;

        @ManyToOne
        @JoinColumn(name = "idUser")
        private User user;

  /*  @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "idProduct")
        private Product productCart;*/
    @JsonIgnore
        @OneToMany(mappedBy = "cart")
        private List<Claim>  claims ;
 @OneToMany(mappedBy = "cart")
 private List<Product> products;
    }

