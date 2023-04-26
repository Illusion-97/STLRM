package dwn.slrm.business.projets;

import dwn.slrm.business.Personne.Personne;
import dwn.slrm.business.competence.Competence;
import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projet extends BaseEntity {
    private String nom;
    @ElementCollection
    private List<String> contenus;
    @ManyToMany
    private List<Competence> competences;
    @ManyToMany
    private List<Personne> participants;
}
