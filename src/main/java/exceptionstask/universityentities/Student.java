package exceptionstask.universityentities;

import java.util.Arrays;

public class Student extends Group {
    private String name;
    private String surname;
    private Mark[] marks;

    public Student(String nameOfFaculty, String groupNumber, String name, String surname, Mark[] marks) throws SubjectException {
        super(nameOfFaculty, groupNumber);
        if (marks == null || marks.length == 0) {
            throw new SubjectException("Student must have at least one subject");
        }
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }

    public Mark[] getSubjects() {
        return marks;
    }

    public void setSubjects(Mark[] marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
