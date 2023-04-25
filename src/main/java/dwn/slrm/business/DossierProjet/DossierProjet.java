package dwn.slrm.business.DossierProjet;

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
public class DossierProjet extends BaseEntity {
    private String annee;
}
