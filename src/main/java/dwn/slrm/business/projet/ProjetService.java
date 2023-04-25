package dwn.slrm.business.projet;

import dwn.slrm.generic.services.AbstractCrudServiceImpl;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProjetService extends AbstractCrudServiceImpl<Projet, ProjetDto, ProjetRepository, ProjetMapper>
        implements IAbstractCrudService<Projet,ProjetDto> {
    public ProjetService(ProjetRepository repo, ProjetMapper mapper) {
        super(repo, mapper);
    }
}
