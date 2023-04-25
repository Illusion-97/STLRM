package dwn.slrm.business.Personne;

import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personne extends BaseEntity {
    private String nom;
    private String prenom;
}
