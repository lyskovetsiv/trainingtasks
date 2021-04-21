package exceptionstask.universityentities;

import java.util.Arrays;

public class Student extends Group {
    String name;
    String surname;
    Subject[] subjects;

    public Student(String nameOfFaculty, String groupNumber, String name, String surname, Subject[] subjects) throws SubjectException {
        super(nameOfFaculty, groupNumber);
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;

        if (subjects == null || subjects.length == 0) {
            throw new SubjectException("Student must have at least one subject");
        }
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
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
                ", subjects=" + Arrays.toString(subjects) +
                '}';
    }
}
