package dwn.slrm.business.annexes;

import java.io.Serializable;
public record AnnexeDto(long id, String name, String extension, String type) implements Serializable {
}
