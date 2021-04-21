package exceptionstask.universityentities;

public class Faculty {
    private String nameOfFaculty;

    public Faculty(String nameOfFaculty) {
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
}
