package exceptionstask;

import exceptionstask.exceptions.*;
import exceptionstask.universityentities.*;

import java.util.Arrays;
import java.util.List;

public class StudentsData {

    public static void main(String[] args) {
        try {
            List<Student> students = Arrays.asList(
                    new Student("MFF", "33", "Konstantin", "Ivanov", new Mark[]{new Mark("Maths", 9),
                            new Mark("Computer Science", 10)}),
                    new Student("MFF", "33", "Kirill", "Osipov", new Mark[]{new Mark("Maths", 5),
                            new Mark("Physics", 9), new Mark("Chemistry", 7)}),
                    new Student("MFF", "98", "Oleg", "Beliy", new Mark[]{new Mark("Computer Science", 4)}),
                    new Student("JPU", "55", "Ilya", "Federov", new Mark[]{new Mark("Maths", 7),
                            new Mark("Chemistry", 9)}),
                    new Student("MFF", "98", "Valeriy", "Volkov", new Mark[]{new Mark("Maths", 6)}),
                    new Student("MFF", "25", "John", "Martin", new Mark[]{new Mark("Maths", 2)}),
                    new Student("JPU", "55", "Stan", "Cooper", new Mark[]{new Mark("Chemistry", 8),
                            new Mark("History", 7)}),
                    new Student("SOFT", "12", "Stanley", "White", new Mark[]{new Mark("Maths", 6)}),
                    new Student("MFF", "98", "Alexander", "Kane", new Mark[]{new Mark("Physics", 5)}),
                    new Student("SOFT", "12", "Martin", "King", new Mark[]{new Mark("Maths", 9)}),
                    new Student("MFF", "25", "Olga", "Alekseeva", new Mark[]{new Mark("Maths", 7)})
            );
            StudentsHierarchy allStudents = new StudentsHierarchy(students);

            System.out.println(allStudents.getAllStudentsInUniversity());
            allStudents.showUniversityHierarchy();
            System.out.println(allStudents.getAverageGradeOfStudent("Ivanov", "Konstantin"));
            System.out.println(allStudents.getAverageSubjectGradeInCertainGroupAndFaculty("JPU", "55", "Chemistry"));
            System.out.println(allStudents.getAverageSubjectGradeInUniversity("Maths"));
        } catch (IllegalGradeException | NoSubjectException | NoSpecificSubjectGradeException | NoSuchFacultyOrGroupException | NoSuchStudentException exception) {
            exception.printStackTrace();
        }
    }

}
