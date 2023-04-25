package dwn.slrm.business.Personne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Personne} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDto implements Serializable {
    private long id;
    private int version;
    private String nom;
    private String prenom;
}
