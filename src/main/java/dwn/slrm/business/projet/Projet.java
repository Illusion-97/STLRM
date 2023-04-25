package dwn.slrm.business.projet;

import dwn.slrm.business.Personne.Personne;
import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projet extends BaseEntity {
    private String nom;
    private Set<Personne> participants;
    private List<String> contenus;
}
