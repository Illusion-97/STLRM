package dwn.slrm.business.DossierProjet;

import dwn.slrm.business.competence.Competence;
import dwn.slrm.business.competence.CompetenceDto;
import dwn.slrm.business.competence.CompetenceService;
import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.DOSSIERPROJET_PREFIX)
public class DossierProjetController extends AbstractController<Competence, CompetenceDto, CompetenceService> {
    protected DossierProjetController(CompetenceService service) {
        super(service, Constants.DOSSIERPROJET_PREFIX);
    }
}
