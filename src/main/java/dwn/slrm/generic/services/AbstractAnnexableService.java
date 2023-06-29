package dwn.slrm.generic.services;

import dwn.slrm.business.annexes.Annexe;
import dwn.slrm.business.annexes.AnnexeRepo;
import dwn.slrm.business.annexes.files.FileStorageService;
import dwn.slrm.generic.mappers.GenericMapper;
import dwn.slrm.generic.models.AnnexableEntity;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public abstract class AbstractAnnexableService
        <
            Entity extends AnnexableEntity,
            DTO,
            Repository extends JpaRepository<Entity,Long>,
            Mapper extends GenericMapper<Entity,DTO>
        > extends AbstractCrudServiceImpl<Entity, DTO, Repository, Mapper>
        implements IAbstractAnnexableService<Entity,DTO> {

    private final FileStorageService storageService;
    private final AnnexeRepo annexeRepo;

    public AbstractAnnexableService(Repository repo, Mapper mapper, FileStorageService storageService, AnnexeRepo annexeRepo) {
        super(repo, mapper);
        this.storageService = storageService;
        this.annexeRepo = annexeRepo;
    }

    @Override
    public void deleteFileById(long entityId, long annexeId) {
        // Récupérer l'entité Annexe
        annexeRepo.findById(annexeId).ifPresent(annexe -> {
            // Récupérer l'entité censée contenir l'annexe
            // Entity entity = repo.getReferenceById(entityId);
            repo.findById(entityId).ifPresent(entity -> {
                entity.getAnnexes().remove(annexe);
                repo.save(entity);
                storageService.delete(annexe);
            });
        });
    }

    @Override
    public void addAnnexe(long entityId, MultipartFile file) {
        // Récupérer le nom du fichier
        String filename = Objects.requireNonNull(file.getOriginalFilename());
        // Récupérer l'entité à laquelle associer l'annexe
        Entity entity = repo.getReferenceById(entityId);
        // je vais soit récupérer une annexe existante avec le même nom, soit récupérer celle créée par la méthode saveFile du storageService

        // Annexe annexe = annexeRepo.findByName(filename).orElse(storageService.saveFile(file,filename));
        // Optional.orElse(function) exécutera le code le fonction afin de connaitre à l'avance la donnée à retourner
        // dans le cas ou il ne trouverait pas celle demandée
        // Pour éviter cela, on utilisera :
        Annexe annexe = annexeRepo.findByName(filename).orElseGet(() -> storageService.saveFile(file,filename));

            // ajouter l'annexe la liste de l'entité à condition qu'elle n'y soit pas déjà
            if(!entity.getAnnexes().contains(annexe)){
                entity.getAnnexes().add(annexe);
                repo.save(entity);
            }

    }

    public Resource load(String filename) {
        return storageService.load(filename);
    }
}
