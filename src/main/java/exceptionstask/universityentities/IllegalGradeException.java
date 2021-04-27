package exceptionstask.universityentities;

public class IllegalGradeException extends Exception{
    public IllegalGradeException() {
    }

    public IllegalGradeException(String message) {
        super(message);
    }

    public IllegalGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalGradeException(Throwable cause) {
        super(cause);
    }
}
