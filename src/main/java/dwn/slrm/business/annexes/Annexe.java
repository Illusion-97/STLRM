package dwn.slrm.business.annexes;

import dwn.slrm.generic.models.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * The type Annexe.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Annexe extends BaseEntity implements Serializable {

    private String name;
    private String extension;
    private String type;

}
