package exceptionstask;

import exceptionstask.universityentities.Mark;
import exceptionstask.universityentities.NoSpecificSubjectGrade;
import exceptionstask.universityentities.NoSuchFacultyOrGroupException;
import exceptionstask.universityentities.Student;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StudentsHierarchy {
    private List<Student> allStudentsInUniversity;

    public StudentsHierarchy(List<Student> allStudentsInUniversity) {
        this.allStudentsInUniversity = allStudentsInUniversity;
    }

    public List<Student> getAllStudentsInUniversity() {
        return allStudentsInUniversity;
    }

    public void showUniversityHierarchy() {
        for (String uniqueFaculty : getUniqueFaculties()) {
            System.out.println(uniqueFaculty + ": ");
            for (String uniqueGroup : getUniqueGroupsForEveryFaculty(uniqueFaculty)) {
                    System.out.println("   " + uniqueGroup + ": ");
                    for (Student student : getAllStudentsInGroup(uniqueGroup)) {
                        System.out.println("     -" + student.getSurname() + " " + student.getName());
                }
            }
        }
    }

    public Set<String> getUniqueFaculties() {
        Set<String> uniqueFaculties = new LinkedHashSet<>();

        for (Student student : allStudentsInUniversity) {
            uniqueFaculties.add(student.getNameOfFaculty());
        }
        return uniqueFaculties;
    }

    public Set<String> getUniqueGroupsForEveryFaculty(String uniqueFaculty) {
        Set<String> uniqueGroups = new LinkedHashSet<>();

            for (Student student : allStudentsInUniversity) {
                if (student.getNameOfFaculty().equals(uniqueFaculty)) {
                uniqueGroups.add(student.getGroupNumber());
            }
        }
        return uniqueGroups;
    }

    public Set<Student> getAllStudentsInGroup(String uniqueGroup) {
        Set<Student> studentsInGroup = new LinkedHashSet<>();

        for (Student student : allStudentsInUniversity) {
            if(student.getGroupNumber().equals(uniqueGroup)) {
                studentsInGroup.add(student);
            }
        }
        return studentsInGroup;
    }

    public double getAverageGradeOfStudent(String surname, String name) {
        int gradeCounter = 0;
        int sumGrades = 0;

        for (Student student : allStudentsInUniversity) {
            if (surname.equals(student.getSurname()) && name.equals(student.getName())) {
                for (Mark mark : student.getMarks()) {
                    sumGrades += mark.getGrade();
                    gradeCounter++;
                }
            }
        }
        return (double) sumGrades/gradeCounter;
    }

    public double getAverageSubjectGradeInUniversity(String subjectName) throws NoSpecificSubjectGrade {
        int gradeCounter = 0;
        int sumGrades = 0;

        for (Student student : allStudentsInUniversity) {
            for (Mark mark : student.getMarks()) {
                if(mark.getName().equals(subjectName)) {
                    sumGrades += mark.getGrade();
                    gradeCounter++;
                }
            }
        }
        if (gradeCounter == 0) {
            throw new NoSpecificSubjectGrade();
        }

        return (double) sumGrades / gradeCounter;
    }

    public double getAverageSubjectGradeInCertainGroupOnCertainFaculty(String faculty, String groupNumber, String subjectName) throws NoSuchFacultyOrGroupException {
        int gradeCounter = 0;
        int sumGrades = 0;
        double averageNumber = -1;

        for (Student student : allStudentsInUniversity) {
            if (student.getNameOfFaculty().equals(faculty) && student.getGroupNumber().equals(groupNumber)) {
                for (Mark mark : student.getMarks()) {
                    if (mark.getName().equals(subjectName)) {
                        sumGrades += mark.getGrade();
                        gradeCounter++;
                    }
                }
            }
        }
        if (gradeCounter == 0) {
            throw new NoSuchFacultyOrGroupException();
        }

        return  (double)sumGrades / gradeCounter;
    }
}
