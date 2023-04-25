package dwn.slrm.business.resume;

import dwn.slrm.generic.services.AbstractCrudServiceImpl;
import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ResumeService extends AbstractCrudServiceImpl<Resume, ResumeDto, ResumeRepository, ResumeMapper>
        implements IAbstractCrudService<Resume,ResumeDto> {
    public ResumeService(ResumeRepository repo, ResumeMapper mapper) {
        super(repo, mapper);
    }
}
