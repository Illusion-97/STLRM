package dwn.slrm.business.competence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Competence} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetenceDto implements Serializable {
    private long id;
    private int version;
    private String nom;
}
