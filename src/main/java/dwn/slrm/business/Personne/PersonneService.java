package dwn.slrm.business.Personne;

import dwn.slrm.generic.services.AbstractCrudServiceImpl;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class PersonneService  extends AbstractCrudServiceImpl<Personne, PersonneDto, PersonneRepository, PersonneMapper>
        implements IAbstractCrudService<Personne,PersonneDto> {
    public PersonneService(PersonneRepository repo, PersonneMapper mapper) {
        super(repo, mapper);
    }
}
