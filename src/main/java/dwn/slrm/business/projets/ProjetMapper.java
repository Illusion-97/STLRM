package dwn.slrm.business.projets;

import dwn.slrm.generic.mappers.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ProjetMapper extends GenericMapper<Projet, ProjetDto> {
}
