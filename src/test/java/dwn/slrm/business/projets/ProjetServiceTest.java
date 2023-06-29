package dwn.slrm.business.projets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest // Initialise le contexte Spring pour les tests
class ProjetServiceTest {

    @Autowired
    private ProjetService service;

    @MockBean // Remplace dans le contexte la classe afin de pouvoir simuler son comportement
    private ProjetMapper mapper;

    @MockBean
    private ProjetRepository repository;

    @Test
    void givenNothing_whenAll_thenReturnDtos() {
        // Arrange
        Projet projet1 = new Projet("News",null,null,null);
        Projet projet2 = new Projet("Comparator",null,null,null);
        List<Projet> entities = List.of(projet1,projet2);

        ProjetDto projetDto1 = new ProjetDto(1L, 0,"News",null,null,null);
        ProjetDto projetDto2 = new ProjetDto(2L, 0,"Comparator",null,null,null);
        List<ProjetDto> dtos = List.of(projetDto1,projetDto2);

        Mockito.when(repository.findAll()).thenReturn(entities);
        Mockito.when(mapper.toDto(projet1)).thenReturn(projetDto1);
        Mockito.when(mapper.toDto(projet2)).thenReturn(projetDto2);

        // Act
        List<ProjetDto> result = service.all();

        // Assert
        assertTrue(result.containsAll(dtos));
    }

    @Test
    void givenDto_whenSave_thenAddToList_AndReturnUpdatedDto() {
        // Arrange
        List<Projet> entities = new ArrayList<>();
        ProjetDto dto = new ProjetDto(0L, 0,"News",null,null,null);
        Projet entity = new Projet("News", null, null, null);

        Mockito.when(mapper.toEntity(dto)).thenReturn(entity);
        // En comparaison avec thenReturn, thenAnswer permet d'effectuer des traitements avant le retour de la valeur
        Mockito.when(repository.save(entity)).thenAnswer(invocationOnMock -> {
            entity.setId(1L);
            entities.add(entity);
            return entity;
        });
        Mockito.when(mapper.toDto(ArgumentMatchers.any(Projet.class))).thenAnswer(invocationOnMock -> {
            // Récupère le paramètre passé à la fonction mockée lors de son appel
            Projet argument = invocationOnMock.getArgument(0);
            return new ProjetDto(argument.getId(), argument.getVersion(), argument.getNom(), null, null, null);
        });

        // Act
        ProjetDto result = service.save(dto);
        assertAll(
                () -> assertEquals(1L, result.getId()),
                () -> assertTrue(entities.contains(entity))
        );
    }


    private static Stream<Arguments> byIdProvider() {
        Projet projet1 = new Projet("News",null,null,null);
        projet1.setId(1L);
        Projet projet2 = new Projet("Comparator",null,null,null);
        projet2.setId(2L);
        List<Projet> entities = List.of(projet1,projet2);

        return Stream.of(
                Arguments.of(entities, 1L, 1L),
                Arguments.of(entities, 2L, 2L),
                Arguments.of(entities, 3L, 0L)
        );
    }

    @ParameterizedTest
    @MethodSource("byIdProvider")
    void givenProvider_whenById_thenReturnFoundOrNew(List<Projet> entities, long id, long expectedId) {
        Mockito.when(repository.findById(id))
                .thenReturn(entities.stream().filter(projet -> projet.getId() == id).findFirst());

        // à sortir dans une méthode
        Mockito.when(mapper.toDto(ArgumentMatchers.any(Projet.class))).thenAnswer(invocationOnMock -> {
            // Récupère le paramètre passé à la fonction mockée lors de son appel
            Projet argument = invocationOnMock.getArgument(0);
            return new ProjetDto(argument.getId(), argument.getVersion(), argument.getNom(), null, null, null);
        });

        ProjetDto result = service.byId(id);

        assertEquals(expectedId,result.getId());
    }
}
