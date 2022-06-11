package ua.palamar.exception;

import java.io.IOException;

public class CanNotOpenFileException extends IOException {
    public CanNotOpenFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
