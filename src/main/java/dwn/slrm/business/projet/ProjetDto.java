package dwn.slrm.business.projet;

import dwn.slrm.business.Personne.PersonneDto;
import dwn.slrm.business.competence.CompetenceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link Projet} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDto implements Serializable {
    private long id;
    private int version;
    private String nom;
    private Set<PersonneDto> participants;
    private List<CompetenceDto> competences;
    private List<String> contenus;
}
