package dwn.slrm.generic.formatters;

import dwn.slrm.generic.GenericTools;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;

public interface AbstractFormatter<Dto> extends Formatter<Dto> {
    // this.getClass() -> CompetenceFormatter implements Formatter<CompetenceDto>
    @Override
    default Dto parse(String text, Locale locale) throws ParseException {
        Dto dto = GenericTools.getEntity(this.getClass(),0,0);
        try {
            Objects.requireNonNull(dto.getClass().getDeclaredMethod("setId", long.class))
                    .invoke(dto,Long.parseLong(text));
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    default String print(Dto object, Locale locale) {
        try {
            return Objects.toString(
                    Objects.requireNonNull(object.getClass().getDeclaredMethod("getId"))
                    .invoke(object), "0");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
