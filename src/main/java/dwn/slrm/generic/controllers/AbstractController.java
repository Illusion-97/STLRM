package dwn.slrm.generic.controllers;

import dwn.slrm.generic.services.IAbstractCrudService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class AbstractController<Entity,Dto,Service extends IAbstractCrudService<Entity,Dto>> {

    protected final Service service;
    protected final String prefix;

    protected AbstractController(Service service, String prefix) {
        this.service = service;
        this.prefix = prefix;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("elements", service.all());
        return prefix + "/all";
    }
}
