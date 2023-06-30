package dwn.slrm.generic.services;

import dwn.slrm.business.projets.Projet;
import dwn.slrm.business.projets.ProjetDto;
import dwn.slrm.generic.mappers.GenericMapper;
import dwn.slrm.generic.models.BaseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public abstract class AbstractCrudServiceImplTest<
        Entity extends BaseEntity,
        Dto,
        Repository extends JpaRepository<Entity,Long>,
        Mapper extends GenericMapper<Entity,Dto>> {

    protected final AbstractCrudServiceImpl<Entity,Dto,Repository,Mapper> service;

    @MockBean
    protected final Repository repository;

    @MockBean
    protected final Mapper mapper;

    protected final List<Entity> entities;
    protected final List<Dto> dtos;

    protected AbstractCrudServiceImplTest(AbstractCrudServiceImpl<Entity, Dto, Repository, Mapper> service, Repository repository, Mapper mapper, List<Entity> entities, List<Dto> dtos) {
        this.service = service;
        this.repository = repository;
        this.mapper = mapper;
        this.entities = new ArrayList<>(entities);
        this.dtos = dtos;
    }


    @Test
    void givenNothing_whenAll_thenReturnDtos() {
        // Arrange

        Mockito.when(repository.findAll()).thenReturn(entities);
        Mockito.when(mapper.toDto(any())).thenAnswer(invocationOnMock ->
                dtos.get(entities.indexOf(invocationOnMock.<Entity>getArgument(0))))
                /*.thenAnswer(invocationOnMock -> {
            Entity entity = invocationOnMock.getArgument(0);
            int entityIndex = entities.indexOf(entity);
            return dtos.get(entityIndex);
        })*/;

        // Act
        List<Dto> result = service.all();

        // Assert
        assertTrue(result.containsAll(dtos));
    }

    protected abstract Dto getDtoToSave();
    protected abstract Entity getEntityToSave();

    protected abstract Dto mapToDto(Entity entity);
    protected abstract boolean isSaved(Dto dto);
    @Test
    void givenDto_whenSave_thenAddToList_AndReturnUpdatedDto() {
        // Arrange
        Entity entity = getEntityToSave();
        Dto dto = getDtoToSave();
        Mockito.when(mapper.toEntity(dto)).thenReturn(entity);
        // En comparaison avec thenReturn, thenAnswer permet d'effectuer des traitements avant le retour de la valeur
        Mockito.when(repository.save(entity)).thenAnswer(invocationOnMock -> {
            entity.setId(1L);
            entities.add(entity);
            return entity;
        });
        Mockito.when(mapper.toDto(any())).thenAnswer(invocationOnMock -> {
            // Récupère le paramètre passé à la fonction mockée lors de son appel
            Entity argument = invocationOnMock.getArgument(0);
            return mapToDto(argument);
        });

        // Act
        Dto result = service.save(dto);
        assertAll(
                //() -> assertEquals(1L, result.getClass().getDeclaredField("id").get(result)),
                () -> assertTrue(isSaved(result)),
                () -> assertTrue(entities.contains(entity))
        );
    }


    protected abstract long getId(Dto dto);
    @ParameterizedTest
    @MethodSource("byIdProvider")
    void givenProvider_whenById_thenReturnFoundOrNew(List<Entity> entities, long id, long expectedId) {
        Mockito.when(repository.findById(id))
                .thenReturn(entities.stream().filter(projet -> projet.getId() == id).findFirst());

        // à sortir dans une méthode
        Mockito.when(mapper.toDto(any())).thenAnswer(invocationOnMock -> {
            // Récupère le paramètre passé à la fonction mockée lors de son appel
            Entity argument = invocationOnMock.getArgument(0);
            return mapToDto(argument);
        });

        Dto result = service.byId(id);

        assertEquals(expectedId,getId(result));
    }
}
