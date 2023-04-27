package dwn.slrm.business.resume;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import dwn.slrm.generic.exceptions.UnauthorizedException;
import dwn.slrm.generic.models.Langues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(Constants.RESUME_PREFIX)
public class ResumeController extends AbstractController<Resume,ResumeDto,ResumeService> {
    protected ResumeController(ResumeService service) {
        super(service, Constants.RESUME_PREFIX);
    }

    @Override
    public String all(Model model) {
        throw new UnauthorizedException();
    }


    @GetMapping("/create/{dossierId}/{langue}")
    public String create(@PathVariable long dossierId, @PathVariable Langues langue, Model model) {
        model.addAttribute("element", new ResumeDto(0,0, langue, "",dossierId));
        return byIdPath;
    }

    @Override
    @PostMapping
    public String save(@ModelAttribute("element") @Validated ResumeDto element, BindingResult result, Model model) {
        return super.save(element, result, model).contentEquals(byIdPath)
                ? byIdPath
                : redirect(Constants.DOSSIERPROJET_PREFIX + "/" + element.dossierId());
    }
}
