package tn.esprit.msclaim.Entities;

import jakarta.persistence.*;
import lombok.*;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;
    private String username;
    private String email;
    private String password;
    private String country;
    private String gouvernment;
    private Boolean banned;
    private Boolean etat;
    private Boolean verified;
    private int phone;
    private Boolean disponibilite;
    private String image;
    @Enumerated(EnumType.STRING)
    private Role role ;
    @ManyToMany(mappedBy = "users")
    private List<Claim> claimList;
    private int complaintCount = 0;
    //@Transient
//    @ManyToMany
//    @JoinTable(
//            name = "Orderc",
//            joinColumns = @JoinColumn(name = "idUser"),
//            inverseJoinColumns = @JoinColumn(name = "idProduct"))
//    private List <Product> productListOrder;
//
//
//    @ManyToMany
//    @JoinTable(
//            name = "Cart",
//            joinColumns = @JoinColumn(name = "idUser"),
//            inverseJoinColumns = @JoinColumn(name = "idProduct"))
//    private List <Product> productListCart;
//
//
//    @OneToMany(mappedBy = "userPost")
//    private List<Post>posts;
//
//     @OneToMany(mappedBy = "userComment")
//     List<CommentPost>commentList;
//
//
//    @OneToMany(mappedBy = "user")
//    private List<Delivery>deliveryList;
//
//

//
//    @OneToMany(mappedBy = "userRating")
//    private List<RatingProduct> ratingProductList;
//
//
   @OneToMany(mappedBy = "userProduct")
   private List<Product> productListUser;

    
}
