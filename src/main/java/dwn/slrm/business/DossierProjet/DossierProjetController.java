package dwn.slrm.business.DossierProjet;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.DOSSIERPROJET_PREFIX)
public class DossierProjetController extends AbstractController<DossierProjet, DossierProjetDto, DossierProjetService> {
    protected DossierProjetController(DossierProjetService service) {
        super(service, Constants.DOSSIERPROJET_PREFIX);
    }
}
