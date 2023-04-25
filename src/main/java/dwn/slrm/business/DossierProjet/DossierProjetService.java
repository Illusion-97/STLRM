package dwn.slrm.business.DossierProjet;

import dwn.slrm.generic.services.AbstractCrudServiceImpl;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class DossierProjetService
        extends AbstractCrudServiceImpl<DossierProjet, DossierProjetDto, DossierProjetRepository, DossierProjetMapper>
        implements IAbstractCrudService<DossierProjet,DossierProjetDto> {
    public DossierProjetService(DossierProjetRepository repo, DossierProjetMapper mapper) {
        super(repo, mapper);
    }
}
