package exceptionstask;

import exceptionstask.universityentities.IllegalGradeException;
import exceptionstask.universityentities.Student;
import exceptionstask.universityentities.Subject;
import exceptionstask.universityentities.SubjectException;

import java.util.Arrays;
import java.util.List;

public class StudentsData {

    public static void main(String[] args) {
        try {
            List<Student> students = Arrays.asList(
                    new Student("MFF", "33", "Konstantin", "Ivanov", new Subject[]{new Subject("Maths", 8),
                            new Subject("Computer Science", 10)}),
                    new Student("MFF", "33", "Kirill", "Osipov", new Subject[]{new Subject("Maths", 5),
                            new Subject("Physics", 9), new Subject("Chemistry", 7)}),
                    new Student("MFF", "98", "Oleg", "Beliy", new Subject[]{new Subject("Computer Science", 4)}),
                    new Student("JPU", "55", "Ilya", "Federov", new Subject[]{new Subject("Maths", 7),
                            new Subject("Chemistry", 9)}),
                    new Student("MFF", "98", "Valeriy", "Volkov", new Subject[]{new Subject("Maths", 6)}),
                    new Student("MFF", "25", "John", "Martin", new Subject[]{new Subject("Maths", 2)}),
                    new Student("JPU", "55", "Stan", "Cooper", new Subject[]{new Subject("Chemistry", 8),
                            new Subject("History", 7)}),
                    new Student("SOFT", "12", "Stanley", "White", new Subject[]{new Subject("Maths", 6)}),
                    new Student("MFF", "98", "Alexander", "Kane", new Subject[]{new Subject("Physics", 5)}),
                    new Student("SOFT", "12", "Martin", "King", new Subject[]{new Subject("Maths", 9)}),
                    new Student("MFF", "25", "Olga", "Alekseeva", new Subject[]{new Subject("Maths", 7)})
            );
            StudentsHierarchy allStudents = new StudentsHierarchy(students);

            System.out.println(allStudents.getAllStudentsInUniversity());
            allStudents.showUniversityHierarchy();
            System.out.println(allStudents.getAverageGradeOfStudent("Ivanov", "Konstantin"));
            System.out.println(allStudents.getAverageSubjectGradeInCertainGroupOnCertainFaculty("JPU", "55", "Chemistry"));
            System.out.println(allStudents.getAverageSubjectGradeInUniversity("Maths"));
        } catch (IllegalGradeException | SubjectException exception) {
            exception.printStackTrace();
        }
    }

}
