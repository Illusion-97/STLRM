package dwn.slrm.business.annexes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnexeRepo  extends JpaRepository<Annexe,Long> {
    Optional<Annexe> findByName(String name);

}
