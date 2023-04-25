package dwn.slrm.business.projet;

import dwn.slrm.business.Personne.Personne;
import dwn.slrm.business.competence.Competence;
import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

    @ManyToMany
    private Set<Personne> participants;
    @ManyToMany
    private List<Competence> competences;
    @ElementCollection
    private List<String> contenus;
}
