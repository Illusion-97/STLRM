package dwn.slrm.business.resume;

import dwn.slrm.generic.models.Langues;

public record ResumeDto(long id, int version, Langues langue, String texte, Long dossierId) {
}
