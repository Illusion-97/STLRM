package dwn.slrm.business.competence;

import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Competence extends BaseEntity {
    @NotBlank(message = "Le nom ne peut être vide.")
    private String nom;
}
