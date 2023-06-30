package dwn.slrm.generic.services;

import dwn.slrm.generic.GenericTools;
import dwn.slrm.generic.mappers.GenericMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractCrudServiceImpl<
        Entity,
        Dto,
        Repository extends JpaRepository<Entity,Long>,
        Mapper extends GenericMapper<Entity,Dto>>
        implements IAbstractCrudService<Entity,Dto> {
    protected final Repository repo;
    protected final Mapper mapper;

    public AbstractCrudServiceImpl(Repository repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<Dto> all() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Dto save(Dto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public Dto byId(long id) {
        return mapper.toDto(repo.findById(id).orElse(getNewEntity()));
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    public Entity getNewEntity() {
        return GenericTools.getEntity(this.getClass(), 0,0);
    }
}
