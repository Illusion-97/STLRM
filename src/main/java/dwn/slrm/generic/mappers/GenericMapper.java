package dwn.slrm.generic.mappers;

public interface GenericMapper<Entity, Dto> {
    Entity toEntity(Dto dto);
    Dto toDto(Entity entity);
}
