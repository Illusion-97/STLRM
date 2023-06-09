package dwn.slrm.generic.controllers;

import dwn.slrm.generic.models.Langues;
import dwn.slrm.generic.services.IAbstractCrudService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;


public abstract class AbstractController<Entity,Dto,Service extends IAbstractCrudService<Entity,Dto>> {

    protected final Service service;
    protected final String prefix;
    protected final String allPath;
    protected final String byIdPath;

    protected AbstractController(Service service, String prefix) {
        this.service = service;
        this.prefix = prefix;
        allPath = prefix + "/all";
        byIdPath = prefix + "/byId";
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("elements", service.all());
        return allPath;
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("element", service.byId(id));
        return byIdPath;
    }

    @PostMapping // POST -> /projet
    public String save(@Valid @ModelAttribute(name = "element") Dto element, BindingResult result, Model model) {
        if(result.hasErrors()){
            return byIdPath;
        }
        service.save(element);
        return redirect(prefix);
    }

    // -> ResumeController
    // ResumeController.prefix -> resumes

    // -> ProjetController
    // ProjetController.prefix -> projets
    @ModelAttribute(name = "prefix")
    public String getPrefix(){
        return prefix;
    }

    protected String redirect(String path) {
        return "redirect:/" + path;
    }
    protected String redirect(String path, long id) {
        return redirect(path) + "/" + id;
    }
    @ModelAttribute("langues")
    public List<String> getLanges() {
        return Arrays.stream(Langues.values()).map(Enum::name).toList();
    }
}
