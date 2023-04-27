package dwn.slrm.business.Personne;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.PERSONNE_PREFIX)
public class PersonneController extends AbstractController<Personne, PersonneDto, PersonneService> {
    protected PersonneController(PersonneService service) {
        super(service, Constants.PERSONNE_PREFIX);
    }
}
