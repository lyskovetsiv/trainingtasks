package exceptionstask.exceptions;

public class NoSubjectException extends Exception{
    public NoSubjectException() {
    }

    public NoSubjectException(String message) {
        super("Student must have at least one subject");
    }

    public NoSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSubjectException(Throwable cause) {
        super(cause);
    }
}
