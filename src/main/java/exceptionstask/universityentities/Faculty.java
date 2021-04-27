package exceptionstask.universityentities;

public class Faculty extends University {
    private String nameOfFaculty;

    public Faculty(String nameOfFaculty) {
        super();
        this.nameOfFaculty = nameOfFaculty;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    @Override
    public String toString() {
        return "{ Faculty = " + nameOfFaculty + '\'' +
                " }";
    }

    public Faculty getFaculty(String facultyName) {
        return this;
    }
}
