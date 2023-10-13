package tn.esprit.msclaim.Entities;

import jakarta.persistence.*;
import lombok.*;

//import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idFacture;
    private  String Refrence;
    private String topicFacture;
    private boolean archive;
    private String reference;
    private String priceTotal;

    @OneToOne
    private  Claim claim ;



}
