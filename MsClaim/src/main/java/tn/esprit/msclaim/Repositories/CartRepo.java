package tn.esprit.msclaim.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msclaim.Entities.Cart;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Long> {

}
