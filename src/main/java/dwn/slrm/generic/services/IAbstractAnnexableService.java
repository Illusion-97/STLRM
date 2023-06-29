package dwn.slrm.generic.services;

import org.springframework.web.multipart.MultipartFile;

public interface IAbstractAnnexableService<Entity, DTO> extends IAbstractCrudService<Entity,DTO> {
    void deleteFileById(long entityId, long annexeId);

    void addAnnexe(long entityId, MultipartFile file);
}
