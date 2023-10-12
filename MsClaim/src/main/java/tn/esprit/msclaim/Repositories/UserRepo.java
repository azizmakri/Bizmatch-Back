package tn.esprit.msclaim.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msclaim.Entities.Claim;
import tn.esprit.msclaim.Entities.Role;
import tn.esprit.msclaim.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
User findByIdUserAndRole(Long iduser , Role role);
}
