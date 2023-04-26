package dwn.slrm.business.competence;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T15:36:10+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class CompetenceMapperImpl implements CompetenceMapper {

    @Override
    public Competence toEntity(CompetenceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Competence competence = new Competence();

        competence.setId( dto.getId() );
        competence.setVersion( dto.getVersion() );
        competence.setNom( dto.getNom() );

        return competence;
    }

    @Override
    public CompetenceDto toDto(Competence entity) {
        if ( entity == null ) {
            return null;
        }

        CompetenceDto competenceDto = new CompetenceDto();

        competenceDto.setId( entity.getId() );
        competenceDto.setVersion( entity.getVersion() );
        competenceDto.setNom( entity.getNom() );

        return competenceDto;
    }
}
