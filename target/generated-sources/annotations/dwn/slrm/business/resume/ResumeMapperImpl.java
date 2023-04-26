package dwn.slrm.business.resume;

import dwn.slrm.business.DossierProjet.DossierProjet;
import dwn.slrm.generic.models.Langues;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T09:19:07+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ResumeMapperImpl implements ResumeMapper {

    @Override
    public Resume toEntity(ResumeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Resume resume = new Resume();

        resume.setDossier( resumeDtoToDossierProjet( dto ) );
        resume.setId( dto.id() );
        resume.setVersion( dto.version() );
        resume.setLangue( dto.langue() );
        resume.setTexte( dto.texte() );

        return resume;
    }

    @Override
    public ResumeDto toDto(Resume resume) {
        if ( resume == null ) {
            return null;
        }

        Long dossierId = null;
        long id = 0L;
        int version = 0;
        Langues langue = null;
        String texte = null;

        dossierId = resumeDossierId( resume );
        id = resume.getId();
        version = resume.getVersion();
        langue = resume.getLangue();
        texte = resume.getTexte();

        ResumeDto resumeDto = new ResumeDto( id, version, langue, texte, dossierId );

        return resumeDto;
    }

    protected DossierProjet resumeDtoToDossierProjet(ResumeDto resumeDto) {
        if ( resumeDto == null ) {
            return null;
        }

        DossierProjet dossierProjet = new DossierProjet();

        if ( resumeDto.dossierId() != null ) {
            dossierProjet.setId( resumeDto.dossierId() );
        }

        return dossierProjet;
    }

    private Long resumeDossierId(Resume resume) {
        if ( resume == null ) {
            return null;
        }
        DossierProjet dossier = resume.getDossier();
        if ( dossier == null ) {
            return null;
        }
        long id = dossier.getId();
        return id;
    }
}
