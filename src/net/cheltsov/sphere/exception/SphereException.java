package net.cheltsov.sphere.exception;

public class SphereException extends Exception {
    public SphereException() {
    }
    public SphereException(String message) {
        super(message);
    }
    public SphereException(String message, Throwable cause) {
        super(message, cause);
    }
    public SphereException(Throwable cause) {
        super(cause);
    }
    public SphereException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
