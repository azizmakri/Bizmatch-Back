package tn.esprit.msclaim.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msclaim.Entities.Claim;
import tn.esprit.msclaim.Entities.User;

import java.util.List;

public interface ClaimRepo extends JpaRepository<Claim, Long> {
  List<Claim> findByUser(User user);
  // List<Claim>getClaimById();


}
