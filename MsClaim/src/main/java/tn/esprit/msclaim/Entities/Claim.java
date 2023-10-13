package tn.esprit.msclaim.Entities;

import jakarta.persistence.*;
import lombok.*;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Claim implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long idClaim;
    private String descriptionClaim;
    @Temporal(TemporalType.DATE)
    private Date dateCreationClaim;
    @Enumerated(EnumType.STRING)
    private CategoryClaim categoryClaim;
    @Enumerated(EnumType.STRING)
    private StatusClaim statusClaim;

    @ManyToOne
    private User user;

    @OneToOne
    private Facture facture ;

    @ManyToMany
    private List<User> users;
    @ManyToOne
    private Product product ;
    @ManyToOne
    private Cart cart ;


}
