package exceptionstask.universityentities;

public class SubjectException extends Exception{
    public SubjectException() {
    }

    public SubjectException(String message) {
        super("Student must have at least one subject");
    }

    public SubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubjectException(Throwable cause) {
        super(cause);
    }
}
