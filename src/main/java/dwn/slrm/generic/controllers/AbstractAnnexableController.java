package dwn.slrm.generic.controllers;

import dwn.slrm.generic.models.AnnexableEntity;
import dwn.slrm.generic.services.IAbstractAnnexableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractAnnexableController<
        Entity extends AnnexableEntity,
        DTO,
        Service extends IAbstractAnnexableService<Entity,DTO>>
        extends AbstractController<Entity, DTO, Service> {

    protected AbstractAnnexableController(Service service, String prefix) {
        super(service, prefix);
    }

    @PostMapping("/addAnnexe/{id}")
    public String upload(@PathVariable long id, MultipartFile file) {
        service.addAnnexe(id, file);
        return redirect(prefix,id);
    }

    @GetMapping("/removeAnnexe/{entityId}/{annexeId}")
    public String remove(@PathVariable long entityId, @PathVariable long annexeId) {
        service.deleteFileById(entityId, annexeId);
        return redirect(prefix,entityId);
    }
}
