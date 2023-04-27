package dwn.slrm.business.projets;

import dwn.slrm.business.Personne.PersonneService;
import dwn.slrm.business.competence.CompetenceService;
import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.PROJET_PREFIX)
public class ProjetController extends AbstractController<Projet, ProjetDto, ProjetService> {
    private final PersonneService personneService;
    private final CompetenceService competencesService;

    protected ProjetController(ProjetService service, PersonneService personneService, CompetenceService competencesService) {
        super(service, Constants.PROJET_PREFIX);
        this.personneService = personneService;
        this.competencesService = competencesService;
    }


    @Override
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("personnes", personneService.all());
        model.addAttribute("competences", competencesService.all());
        return super.getById(model, id);
    }

    @Override
    @PostMapping
    public String save(@ModelAttribute("element") @Validated ProjetDto element, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("personnes", personneService.all());
            model.addAttribute("competences", competencesService.all());
            return byIdPath;
        }
        return super.save(element, result, model);
    }
}
