package exceptionstask.universityentities;

public class NoSpecificSubjectGrade extends Exception {
    public NoSpecificSubjectGrade() {
    }

    public NoSpecificSubjectGrade(String message) {
        super("Student doesn't have such subject");
    }

    public NoSpecificSubjectGrade(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSpecificSubjectGrade(Throwable cause) {
        super(cause);
    }
}
