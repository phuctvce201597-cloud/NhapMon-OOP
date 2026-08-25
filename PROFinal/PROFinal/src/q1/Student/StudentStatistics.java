package q1.Student;

import q1.Student.CE.CEStudent;
import q1.Student.CS.CSStudent;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class StudentStatistics {

    /**
     *
     * @param sm
     */
    public static void countByMajor(StudentManager sm) {
        long ceCount = sm.stream()
                .filter(s -> s instanceof CEStudent)
                .count();
        long csCount = sm.stream()
                .filter(s -> s instanceof CSStudent)
                .count();
        System.out.println("=== STUDENT COUNT BY MAJOR ===");
        System.out.println("CE (Computer Engineering): " + ceCount);
        System.out.println("CS (Computer Science)    : " + csCount);
        System.out.println("Total                    : " + sm.size());
    }

    /**
     *
     * @param sm
     */
    public static void findTopGpa(StudentManager sm) {
        System.out.println("=== TOP GPA STUDENT ===");
        if (sm.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Optional<Student> top = sm.stream()
                .max(Comparator.comparingDouble(Student::gpa));
        top.ifPresent(s -> System.out.println(s.print()));
    }

    /**
     *
     * @param sm
     */
    public static void countStudentsPerCourse(StudentManager sm) {
        System.out.println("=== STUDENT COUNT PER COURSE ===");
        if (sm.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Map<String, Long> courseCount = sm.stream()
                .flatMap(s -> s.getEnrollments().stream()
                        .map(e -> e.getCourse().getCourseId()))
                .collect(Collectors.groupingBy(courseId -> courseId, Collectors.counting()));

        if (courseCount.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }
        courseCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println("Course " + entry.getKey() + ": " + entry.getValue() + " student(s)"));
    }

    /**
     *
     * @param sm
     */
    public static void averageGpaByMajor(StudentManager sm) {
        System.out.println("=== AVERAGE GPA BY MAJOR ===");
        OptionalHelper ceAvg = calcAvg(sm.stream()
                .filter(s -> s instanceof CEStudent)
                .collect(Collectors.toList()));
        OptionalHelper csAvg = calcAvg(sm.stream()
                .filter(s -> s instanceof CSStudent)
                .collect(Collectors.toList()));
        System.out.printf("CE average GPA: %.2f%n", ceAvg.value);
        System.out.printf("CS average GPA: %.2f%n", csAvg.value);
    }

    private static OptionalHelper calcAvg(List<Student> list) {
        if (list.isEmpty()) return new OptionalHelper(0.0);
        double avg = list.stream()
                .mapToDouble(Student::gpa)
                .average()
                .orElse(0.0);
        return new OptionalHelper(avg);
    }

    private static class OptionalHelper {
        double value;
        OptionalHelper(double v) { this.value = v; }
    }

    /**
     *
     * @param sm
     * @param studentId
     */
    public static void printTranscript(StudentManager sm, String studentId) {
        System.out.println("=== TRANSCRIPT ===");
        Student student = sm.searchById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println(student.entry());
        if (student.getEnrollments().isEmpty()) {
            System.out.println("No enrollments.");
        } else {
            student.getEnrollments().forEach(e ->
                    System.out.printf("  %-10s | %-25s | Scores: %-30s | Final: %.2f%n",
                            e.getCourse().getCourseId(),
                            e.getCourse().getCourseName(),
                            e.getStudentScores().toString(),
                            e.calculateFinalScore()));
        }
        System.out.printf("Overall GPA: %.2f%n", student.gpa());
    }
}
