package dwn.slrm.business.DossierProjet;

import dwn.slrm.business.Personne.Personne;
import dwn.slrm.business.projets.Projet;
import dwn.slrm.business.resume.Resume;
import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class DossierProjet extends BaseEntity {

    private String annee;
    @ManyToOne
    private Personne candidat;
    @ManyToOne
    private Projet projet;
    @OneToMany(mappedBy = "dossier", orphanRemoval = true)
    private List<Resume> resumes;
}
