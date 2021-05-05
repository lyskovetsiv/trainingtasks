package exceptionstask.universityentities;

import exceptionstask.exceptions.NoSubjectException;

import java.util.Arrays;

public class Student extends Group {
    private String name;
    private String surname;
    private Mark[] marks;

    public Student(String nameOfFaculty, String groupNumber, String name, String surname, Mark[] marks) throws NoSubjectException {
        super(nameOfFaculty, groupNumber);
        if (marks == null || marks.length == 0) {
            throw new NoSubjectException();
        }
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }

    public Mark[] getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
