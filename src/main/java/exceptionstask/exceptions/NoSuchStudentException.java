package exceptionstask.exceptions;

public class NoSuchStudentException extends Exception {
    public NoSuchStudentException() {
    }

    public NoSuchStudentException(String message) {
        super("There's no such student in the university");
    }

    public NoSuchStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchStudentException(Throwable cause) {
        super(cause);
    }
}
