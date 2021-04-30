package exceptionstask.exceptions;

public class IllegalGradeException extends Exception{
    public IllegalGradeException() {
    }

    public IllegalGradeException(String message) {
        super("Grade cannot be out of '0-10' range");
    }

    public IllegalGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalGradeException(Throwable cause) {
        super(cause);
    }
}
