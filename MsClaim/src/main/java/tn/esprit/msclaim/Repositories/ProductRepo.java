package tn.esprit.msclaim.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msclaim.Entities.Cart;
import tn.esprit.msclaim.Entities.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    //public List<Product> getProductByIdProduct(Long idProduct);
}
