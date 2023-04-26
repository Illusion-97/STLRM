package dwn.slrm.business.DossierProjet;

import dwn.slrm.business.Personne.Personne;
import dwn.slrm.business.Personne.PersonneDto;
import dwn.slrm.business.competence.Competence;
import dwn.slrm.business.competence.CompetenceDto;
import dwn.slrm.business.projets.Projet;
import dwn.slrm.business.projets.ProjetDto;
import dwn.slrm.business.resume.Resume;
import dwn.slrm.business.resume.ResumeDto;
import dwn.slrm.generic.models.Langues;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T09:19:07+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class DossierProjetMapperImpl implements DossierProjetMapper {

    @Override
    public DossierProjet toEntity(DossierProjetDto dto) {
        if ( dto == null ) {
            return null;
        }

        DossierProjet dossierProjet = new DossierProjet();

        dossierProjet.setId( dto.getId() );
        dossierProjet.setVersion( dto.getVersion() );
        dossierProjet.setAnnee( dto.getAnnee() );
        dossierProjet.setCandidat( personneDtoToPersonne( dto.getCandidat() ) );
        dossierProjet.setProjet( projetDtoToProjet( dto.getProjet() ) );
        dossierProjet.setResumes( resumeDtoListToResumeList( dto.getResumes() ) );

        return dossierProjet;
    }

    @Override
    public DossierProjetDto toDto(DossierProjet entity) {
        if ( entity == null ) {
            return null;
        }

        DossierProjetDto dossierProjetDto = new DossierProjetDto();

        dossierProjetDto.setId( entity.getId() );
        dossierProjetDto.setVersion( entity.getVersion() );
        dossierProjetDto.setAnnee( entity.getAnnee() );
        dossierProjetDto.setCandidat( personneToPersonneDto( entity.getCandidat() ) );
        dossierProjetDto.setProjet( projetToProjetDto( entity.getProjet() ) );
        dossierProjetDto.setResumes( resumeListToResumeDtoList( entity.getResumes() ) );

        return dossierProjetDto;
    }

    protected Personne personneDtoToPersonne(PersonneDto personneDto) {
        if ( personneDto == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setId( personneDto.getId() );
        personne.setVersion( personneDto.getVersion() );
        personne.setNom( personneDto.getNom() );
        personne.setPrenom( personneDto.getPrenom() );

        return personne;
    }

    protected Competence competenceDtoToCompetence(CompetenceDto competenceDto) {
        if ( competenceDto == null ) {
            return null;
        }

        Competence competence = new Competence();

        competence.setId( competenceDto.getId() );
        competence.setVersion( competenceDto.getVersion() );
        competence.setNom( competenceDto.getNom() );

        return competence;
    }

    protected List<Competence> competenceDtoListToCompetenceList(List<CompetenceDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Competence> list1 = new ArrayList<Competence>( list.size() );
        for ( CompetenceDto competenceDto : list ) {
            list1.add( competenceDtoToCompetence( competenceDto ) );
        }

        return list1;
    }

    protected List<Personne> personneDtoListToPersonneList(List<PersonneDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Personne> list1 = new ArrayList<Personne>( list.size() );
        for ( PersonneDto personneDto : list ) {
            list1.add( personneDtoToPersonne( personneDto ) );
        }

        return list1;
    }

    protected Projet projetDtoToProjet(ProjetDto projetDto) {
        if ( projetDto == null ) {
            return null;
        }

        Projet projet = new Projet();

        if ( projetDto.getId() != null ) {
            projet.setId( projetDto.getId() );
        }
        if ( projetDto.getVersion() != null ) {
            projet.setVersion( projetDto.getVersion() );
        }
        projet.setNom( projetDto.getNom() );
        List<String> list = projetDto.getContenus();
        if ( list != null ) {
            projet.setContenus( new ArrayList<String>( list ) );
        }
        projet.setCompetences( competenceDtoListToCompetenceList( projetDto.getCompetences() ) );
        projet.setParticipants( personneDtoListToPersonneList( projetDto.getParticipants() ) );

        return projet;
    }

    protected Resume resumeDtoToResume(ResumeDto resumeDto) {
        if ( resumeDto == null ) {
            return null;
        }

        Resume resume = new Resume();

        resume.setId( resumeDto.id() );
        resume.setVersion( resumeDto.version() );
        resume.setLangue( resumeDto.langue() );
        resume.setTexte( resumeDto.texte() );

        return resume;
    }

    protected List<Resume> resumeDtoListToResumeList(List<ResumeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Resume> list1 = new ArrayList<Resume>( list.size() );
        for ( ResumeDto resumeDto : list ) {
            list1.add( resumeDtoToResume( resumeDto ) );
        }

        return list1;
    }

    protected PersonneDto personneToPersonneDto(Personne personne) {
        if ( personne == null ) {
            return null;
        }

        PersonneDto personneDto = new PersonneDto();

        personneDto.setId( personne.getId() );
        personneDto.setVersion( personne.getVersion() );
        personneDto.setNom( personne.getNom() );
        personneDto.setPrenom( personne.getPrenom() );

        return personneDto;
    }

    protected CompetenceDto competenceToCompetenceDto(Competence competence) {
        if ( competence == null ) {
            return null;
        }

        CompetenceDto competenceDto = new CompetenceDto();

        competenceDto.setId( competence.getId() );
        competenceDto.setVersion( competence.getVersion() );
        competenceDto.setNom( competence.getNom() );

        return competenceDto;
    }

    protected List<CompetenceDto> competenceListToCompetenceDtoList(List<Competence> list) {
        if ( list == null ) {
            return null;
        }

        List<CompetenceDto> list1 = new ArrayList<CompetenceDto>( list.size() );
        for ( Competence competence : list ) {
            list1.add( competenceToCompetenceDto( competence ) );
        }

        return list1;
    }

    protected List<PersonneDto> personneListToPersonneDtoList(List<Personne> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonneDto> list1 = new ArrayList<PersonneDto>( list.size() );
        for ( Personne personne : list ) {
            list1.add( personneToPersonneDto( personne ) );
        }

        return list1;
    }

    protected ProjetDto projetToProjetDto(Projet projet) {
        if ( projet == null ) {
            return null;
        }

        ProjetDto projetDto = new ProjetDto();

        projetDto.setId( projet.getId() );
        projetDto.setVersion( projet.getVersion() );
        projetDto.setNom( projet.getNom() );
        List<String> list = projet.getContenus();
        if ( list != null ) {
            projetDto.setContenus( new ArrayList<String>( list ) );
        }
        projetDto.setCompetences( competenceListToCompetenceDtoList( projet.getCompetences() ) );
        projetDto.setParticipants( personneListToPersonneDtoList( projet.getParticipants() ) );

        return projetDto;
    }

    protected ResumeDto resumeToResumeDto(Resume resume) {
        if ( resume == null ) {
            return null;
        }

        long id = 0L;
        int version = 0;
        Langues langue = null;
        String texte = null;

        id = resume.getId();
        version = resume.getVersion();
        langue = resume.getLangue();
        texte = resume.getTexte();

        Long dossierId = null;

        ResumeDto resumeDto = new ResumeDto( id, version, langue, texte, dossierId );

        return resumeDto;
    }

    protected List<ResumeDto> resumeListToResumeDtoList(List<Resume> list) {
        if ( list == null ) {
            return null;
        }

        List<ResumeDto> list1 = new ArrayList<ResumeDto>( list.size() );
        for ( Resume resume : list ) {
            list1.add( resumeToResumeDto( resume ) );
        }

        return list1;
    }
}
