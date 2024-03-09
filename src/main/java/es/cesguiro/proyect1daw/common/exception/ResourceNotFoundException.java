package es.cesguiro.proyect1daw.common.exception;

public class ResourceNotFoundException extends RuntimeException{

    private static final String errorMessage = "Resource not found: ";

    public ResourceNotFoundException(String message) {
        super(errorMessage + message);
    }
}
