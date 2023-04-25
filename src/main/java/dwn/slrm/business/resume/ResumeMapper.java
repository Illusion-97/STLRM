package dwn.slrm.business.resume;

import dwn.slrm.generic.mappers.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ResumeMapper extends GenericMapper<Resume,ResumeDto> {
    @Mapping(source = "dossierId", target = "dossier.id")
    Resume toEntity(ResumeDto dto);
    @Mapping(source = "dossier.id", target = "dossierId")
    ResumeDto toDto(Resume resume);
}
