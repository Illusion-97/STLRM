package dwn.slrm.generic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("Accès Interdit");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
