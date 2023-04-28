package dwn.slrm.business.annexes;

import dwn.slrm.generic.mappers.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface AnnexeMapper extends GenericMapper<Annexe, AnnexeDto> {
}
