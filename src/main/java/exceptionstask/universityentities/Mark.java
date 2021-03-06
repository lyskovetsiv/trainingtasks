package exceptionstask.universityentities;

import exceptionstask.exceptions.IllegalGradeException;

import java.util.Objects;

public class Mark {
    private String name;
    private int grade;

    public Mark(String name, int grade) throws IllegalGradeException {
        if (grade < 0 || grade > 10) {
            throw new IllegalGradeException();
        }

        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        Mark mark = (Mark) o;
        return grade == mark.grade &&
                Objects.equals(name, mark.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
