package dwn.slrm.business.DossierProjet;

import dwn.slrm.business.Personne.PersonneDto;
import dwn.slrm.business.projet.ProjetDto;
import dwn.slrm.business.resume.ResumeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link DossierProjet} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DossierProjetDto implements Serializable {
    private long id;
    private int version;
    private String annee;
    private PersonneDto candidat;
    private ProjetDto projet;
    private List<ResumeDto> resumes;
}
