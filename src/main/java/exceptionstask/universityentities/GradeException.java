package exceptionstask.universityentities;

public class GradeException extends Exception{
    public GradeException() {
    }

    public GradeException(String message) {
        super(message);
    }

    public GradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GradeException(Throwable cause) {
        super(cause);
    }
}
