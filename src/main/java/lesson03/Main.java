package lesson03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = getStudents();

        List<StudentGradeRecord> grades = students.stream()
                .filter(student -> student.address().city().equals("New York") && student.age() > 15)
                .flatMap(student -> student.grades().stream()
                        .map(grade -> new StudentGradeRecord(student.name(), student.school(), grade.subject(), grade.score())))
                .sorted((g1, g2) -> Double.compare(g2.score(), g1.score()))
                .toList();

        grades.stream()
                .limit(3)
                .forEach(grade -> System.out.println(
                        "Name: " + grade.studentName() +
                                ", school: " + grade.school() +
                                ", subject: " + grade.subject() +
                                ", score:" + grade.score()
                ));
    }

    private static List<Student> getStudents() {
        List<Grade> aliceGrades = List.of(
                new Grade("Math", 95.0),
                new Grade("Physics", 92.0),
                new Grade("Chemistry", 89.0)
        );

        List<Grade> bobGrades = List.of(
                new Grade("Math", 84.0),
                new Grade("Physics", 99.0),
                new Grade("Chemistry", 81.0)
        );

        List<Grade> charlieGrades = List.of(
                new Grade("Math", 100.0),
                new Grade("Physics", 82.0),
                new Grade("Chemistry", 81.0)
        );

        List<Grade> isaacGrades = List.of(
                new Grade("Math", 94.0),
                new Grade("Physics", 96.0),
                new Grade("Chemistry", 91.0)
        );

        List<Grade> jesseGrades = List.of(
                new Grade("Math", 57.0),
                new Grade("Physics", 62.0),
                new Grade("Chemistry", 99.0)
        );

        List<Student> students = new ArrayList<>(List.of());
        students.add(new Student("Alice", 18, aliceGrades, "Oxford", new Address("New York", "5th Avenue")));
        students.add(new Student("Bob", 21, bobGrades, "Harvard", new Address("Boston", "Main Street")));
        students.add(new Student("Charlie", 15, charlieGrades, "MY Middle School", new Address("New York", "Main Street")));
        students.add(new Student("Isaac", 29, isaacGrades, "Cambridge", new Address("New York", "Mill Rd")));
        students.add(new Student("Jesse", 26, jesseGrades, "Albuquerque High School", new Address("New York", "Comanche Road")));

        return students;
    }
}
