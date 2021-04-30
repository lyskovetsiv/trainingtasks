package exceptionstask.universityentities;

public class NoSuchFacultyOrGroupException extends Exception {
    public NoSuchFacultyOrGroupException() {
    }

    public NoSuchFacultyOrGroupException(String message) {
        super(message);
    }

    public NoSuchFacultyOrGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchFacultyOrGroupException(Throwable cause) {
        super(cause);
    }
}
