package dwn.slrm.business.Personne;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T15:36:10+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class PersonneMapperImpl implements PersonneMapper {

    @Override
    public Personne toEntity(PersonneDto dto) {
        if ( dto == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setId( dto.getId() );
        personne.setVersion( dto.getVersion() );
        personne.setNom( dto.getNom() );
        personne.setPrenom( dto.getPrenom() );

        return personne;
    }

    @Override
    public PersonneDto toDto(Personne entity) {
        if ( entity == null ) {
            return null;
        }

        PersonneDto personneDto = new PersonneDto();

        personneDto.setId( entity.getId() );
        personneDto.setVersion( entity.getVersion() );
        personneDto.setNom( entity.getNom() );
        personneDto.setPrenom( entity.getPrenom() );

        return personneDto;
    }
}
