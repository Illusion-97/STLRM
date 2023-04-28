package dwn.slrm.generic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type File storage exception.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class FileStorageException extends RuntimeException {
    /**
     * Instantiates a new File storage exception.
     *
     * @param message the message
     */
    public FileStorageException(String message) {
        super(message);
    }

    /**
     * Instantiates a new File storage exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
