package exceptionstask.exceptions;

public class NoSpecificSubjectGradeException extends Exception {
    public NoSpecificSubjectGradeException() {
    }

    public NoSpecificSubjectGradeException(String message) {
        super("Student doesn't have such subject");
    }

    public NoSpecificSubjectGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSpecificSubjectGradeException(Throwable cause) {
        super(cause);
    }
}
