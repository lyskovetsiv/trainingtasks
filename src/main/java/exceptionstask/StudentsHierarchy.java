package exceptionstask;

import exceptionstask.universityentities.Student;
import exceptionstask.universityentities.Subject;

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

    public int getAverageGradeOfStudent(String surname, String name) {
        int gradeCounter = 0;
        int sumGrades = 0;

        for (Student student : allStudentsInUniversity) {
            if (surname.equals(student.getSurname()) && name.equals(student.getName())) {
                for (Subject subject : student.getSubjects()) {
                    sumGrades += subject.getGrade();
                    gradeCounter++;
                }
            }
        }
        return sumGrades/gradeCounter;
    }

    public int getAverageSubjectGradeInUniversity(String subjectName) {
        int gradeCounter = 0;
        int sumGrades = 0;
        int averageNumber = -1;

        for (Student student : allStudentsInUniversity) {
            for (Subject subject : student.getSubjects()) {
                if(subject.getName().equals(subjectName)) {
                    sumGrades += subject.getGrade();
                    gradeCounter++;
                }
            }
        }
        try {
            averageNumber = sumGrades / gradeCounter;
        }
        catch (ArithmeticException exception) {
            System.out.println("No such subject");
            exception.printStackTrace();
        }
        return averageNumber;
    }

    public int getAverageSubjectGradeInCertainGroupOnCertainFaculty(String faculty, String groupNumber, String subjectName) {
        int gradeCounter = 0;
        int sumGrades = 0;
        int averageNumber = -1;

        for (Student student : allStudentsInUniversity) {
            if (student.getNameOfFaculty().equals(faculty) && student.getGroupNumber().equals(groupNumber)) {
                for (Subject subject : student.getSubjects()) {
                    if (subject.getName().equals(subjectName)) {
                        sumGrades += subject.getGrade();
                        gradeCounter++;
                    }
                }
            }
        }
        try {
            averageNumber = sumGrades / gradeCounter;
        }
        catch (ArithmeticException exception) {
            System.out.println("No such faculty or group");
            exception.printStackTrace();
        }
        return averageNumber;
    }
}
