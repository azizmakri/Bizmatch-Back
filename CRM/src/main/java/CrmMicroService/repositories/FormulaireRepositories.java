package CrmMicroService.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import CrmMicroService.entities.Formulaire;

public interface FormulaireRepositories  extends JpaRepository<Formulaire, Long>{
}
