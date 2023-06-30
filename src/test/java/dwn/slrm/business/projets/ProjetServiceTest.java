package dwn.slrm.business.projets;

import dwn.slrm.generic.services.AbstractCrudServiceImplTest;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest // Initialise le contexte Spring pour les tests
//@ActiveProfiles("test") Activer un profil de lancement -> application-pofile.properties
public class ProjetServiceTest extends AbstractCrudServiceImplTest<Projet, ProjetDto, ProjetRepository, ProjetMapper> {

    @Autowired
    protected ProjetServiceTest(ProjetService service, ProjetRepository repository, ProjetMapper mapper) {
        super(service, repository, mapper, getEntities(), getDtos());
    }

    static List<Projet> getEntities() {
        return List.of(
                new Projet("Admin", null, null, null),
                new Projet("Etud", null, null, null),
                new Projet("Banzai", null, null, null),
                new Projet("Noodle", null, null, null)
        );
    }

    static List<ProjetDto> getDtos() {
        return getEntities().stream()
                //.map(projet -> toDto(projet))
                .map(ProjetServiceTest::toDto)
                .toList();
    }

    static ProjetDto toDto(Projet projet) {
        return new ProjetDto(
                projet.getId(),
                projet.getVersion(),
                projet.getNom(), null, null, null);
    }

    protected static Stream<Arguments> byIdProvider() {
        Projet projet1 = new Projet("News", null, null, null);
        projet1.setId(1L);
        Projet projet2 = new Projet("Comparator", null, null, null);
        projet2.setId(2L);
        List<Projet> entities = List.of(projet1, projet2);

        return Stream.of(
                Arguments.of(entities, 1L, 1L),
                Arguments.of(entities, 2L, 2L),
                Arguments.of(entities, 3L, 0L)
        );
    }


    @Override
    protected ProjetDto getDtoToSave() {
        return new ProjetDto(0L, 0, "ToSave", null, null, null);
    }

    @Override
    protected Projet getEntityToSave() {
        return new Projet("ToSave", null, null, null);
    }

    @Override
    protected ProjetDto mapToDto(Projet entity) {
        return toDto(entity);
    }

    @Override
    protected boolean isSaved(ProjetDto projetDto) {
        return projetDto.getId() == 1L;
    }

    @Override
    protected long getId(ProjetDto projetDto) {
        return projetDto.getId();
    }
}
