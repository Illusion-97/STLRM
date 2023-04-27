package dwn.slrm.business.DossierProjet;

import dwn.slrm.business.Personne.PersonneService;
import dwn.slrm.business.projets.ProjetService;
import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(Constants.DOSSIERPROJET_PREFIX)
public class DossierProjetController extends AbstractController<DossierProjet, DossierProjetDto, DossierProjetService> {
    private final PersonneService personneService;
    private final ProjetService projetService;
    protected DossierProjetController(DossierProjetService service, PersonneService personneService, ProjetService projetService) {
        super(service, Constants.DOSSIERPROJET_PREFIX);
        this.personneService = personneService;
        this.projetService = projetService;
    }

    @Override
    public String getById(Model model, @PathVariable Long id) {
        addRelatives(model);
        return super.getById(model,id);
    }

    @Override
    public String save(@ModelAttribute("element") @Validated DossierProjetDto element, BindingResult result, Model model) {
        if(result.hasErrors()) {
            addRelatives(model);
            return byIdPath;
        }
        return redirect(prefix,service.save(element).getId());
    }

    private void addRelatives(Model model) {
        model.addAllAttributes(
                Map.of(
                        "students",personneService.all(),
                        "projects",projetService.all()
                )
        );
    }
}
