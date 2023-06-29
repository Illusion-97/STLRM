package dwn.slrm.business.DossierProjet;

import dwn.slrm.business.annexes.AnnexeRepo;
import dwn.slrm.business.annexes.files.FileStorageService;
import dwn.slrm.generic.services.AbstractAnnexableService;
import dwn.slrm.generic.services.AbstractCrudServiceImpl;
import dwn.slrm.generic.services.IAbstractAnnexableService;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class DossierProjetService
        extends AbstractAnnexableService<DossierProjet, DossierProjetDto, DossierProjetRepository, DossierProjetMapper>
        implements IAbstractAnnexableService<DossierProjet,DossierProjetDto> {
    public DossierProjetService(DossierProjetRepository repo, DossierProjetMapper mapper, FileStorageService storageService, AnnexeRepo annexeRepo) {
        super(repo, mapper, storageService, annexeRepo);
    }
}
