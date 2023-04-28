package dwn.slrm.business.annexes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnexeRepo  extends JpaRepository<Annexe,Long> {
}
