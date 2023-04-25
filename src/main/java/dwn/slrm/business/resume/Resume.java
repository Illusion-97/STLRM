package dwn.slrm.business.resume;

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
public class Resume extends BaseEntity {
    private String texte;
}
