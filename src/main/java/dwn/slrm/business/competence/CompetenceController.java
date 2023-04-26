package dwn.slrm.business.competence;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.COMPETENCE_PREFIX)
public class CompetenceController extends AbstractController<Competence, CompetenceDto, CompetenceService> {
    protected CompetenceController(CompetenceService service) {
        super(service, Constants.COMPETENCE_PREFIX);
    }
}
