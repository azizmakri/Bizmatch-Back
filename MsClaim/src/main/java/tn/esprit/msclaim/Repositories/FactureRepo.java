package tn.esprit.msclaim.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msclaim.Entities.Facture;

public interface FactureRepo extends JpaRepository<Facture, Long> {
    Facture findByReference(String refence);

}
