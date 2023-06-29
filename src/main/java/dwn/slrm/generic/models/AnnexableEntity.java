package dwn.slrm.generic.models;

import dwn.slrm.business.annexes.Annexe;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class AnnexableEntity extends BaseEntity {
    private List<Annexe> annexes;
}
