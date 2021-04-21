package exceptionstask.universityentities;

public class Group extends Faculty {
    private String groupNumber;

    public Group(String nameOfFaculty, String groupNumber) {
        super(nameOfFaculty);
        this.groupNumber = groupNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "Group = " +
                groupNumber + " }");
    }
}
