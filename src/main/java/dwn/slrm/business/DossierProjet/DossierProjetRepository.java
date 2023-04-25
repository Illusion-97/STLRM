package dwn.slrm.business.DossierProjet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierProjetRepository extends JpaRepository<DossierProjet,Long> {
}
