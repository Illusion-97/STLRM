package dwn.slrm.business.projets;

import dwn.slrm.generic.services.AbstractCrudServiceImpl;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProjetService extends AbstractCrudServiceImpl<Projet, ProjetDto, ProjetRepository, ProjetMapper> implements IAbstractCrudService<Projet,ProjetDto> {
    public ProjetService(ProjetRepository repository, ProjetMapper mapper) {
        super(repository, mapper);
    }

}
