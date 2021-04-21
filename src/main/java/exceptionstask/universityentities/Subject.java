package exceptionstask.universityentities;

import java.util.Objects;

public class Subject {
    String name;
    int grade;

    public Subject(String name, int grade) throws GradeException{
        this.name = name;
        this.grade = grade;

        if (grade < 0 || grade > 10) {
            throw new GradeException("Grade cannot be out of '0-10' range");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return grade == subject.grade &&
                Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
