package dwn.slrm.business.competence;

import dwn.slrm.generic.services.AbstractCrudServiceImpl;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService  extends AbstractCrudServiceImpl<Competence, CompetenceDto, CompetenceRepository, CompetenceMapper>
        implements IAbstractCrudService<Competence,CompetenceDto> {
    public CompetenceService(CompetenceRepository repo, CompetenceMapper mapper) {
        super(repo, mapper);
    }
}
