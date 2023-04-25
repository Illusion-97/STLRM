package dwn.slrm.generic.services;

import dwn.slrm.generic.GenericTools;
import dwn.slrm.generic.mappers.GenericMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractCrudServiceImpl<Entity,Dto>
        implements IAbstractCrudService<Entity,Dto> {
    private final JpaRepository<Entity,Long> repo;
    private final GenericMapper<Entity,Dto> mapper;

    public AbstractCrudServiceImpl(JpaRepository<Entity,Long> repo, GenericMapper<Entity, Dto> mapper) {
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

    private Entity getNewEntity() {
        return GenericTools.getEntity(this.getClass(), 0,0);
    }
}
