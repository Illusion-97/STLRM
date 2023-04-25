package dwn.slrm.generic.services;

import java.util.List;

public interface IAbstractCrudService<Entity,Dto> {
    List<Dto> all();
    Dto save(Dto dto);
    Dto byId(long id);
    void delete(long id);
}
