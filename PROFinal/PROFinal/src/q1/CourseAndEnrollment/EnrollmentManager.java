package q1.CourseAndEnrollment;

import q1.Student.Student;
import q1.Student.StudentManager;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class EnrollmentManager {

    private final Scanner sc = new Scanner(System.in);

    /**
     *
     * @param sm
     * @param cm
     */
    public void addEnrollment(StudentManager sm, CourseManager cm) {

        System.out.print("Input student ID: ");
        String studentId = sc.nextLine().trim().toUpperCase();
        Student student = sm.searchById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Input course ID: ");
        String courseId = sc.nextLine().trim().toUpperCase();
        Course course = cm.searchCourse(courseId);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        for (Enrollment e : student.getEnrollments()) {
            if (e.getCourse().getCourseId().equals(courseId)) {
                System.out.println("Student is already enrolled in this course.");
                return;
            }
        }

        Enrollment enrollment = new Enrollment(course);

        if (!course.getGradingSchema().isEmpty()) {
            for (String column : course.getGradingSchema().keySet()) {
                while (true) {
                    System.out.print("Input score for [" + column + "] (0-10): ");
                    try {
                        double score = Double.parseDouble(sc.nextLine().trim());
                        if (score >= 0 && score <= 10) {
                            enrollment.setScore(column, score);
                            break;
                        }
                        System.out.println("Invalid score. Must be between 0 and 10.");
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid number format.");
                    }
                }
            }
        } else {
            while (true) {
                System.out.print("Input score (0-10): ");
                try {
                    double score = Double.parseDouble(sc.nextLine().trim());
                    if (score >= 0 && score <= 10) {
                        enrollment.setScore("score", score);
                        break;
                    }
                    System.out.println("Invalid score. Must be between 0 and 10.");
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid number format.");
                }
            }
        }

        student.addEnrollment(enrollment);
        System.out.println("Enrolled: " + student.getName() + " -> " + course.getCourseName()
                + " | Final: " + String.format("%.2f", enrollment.calculateFinalScore()));
    }

    /**
     *
     * @param sm
     * @param cm
     */
    public void updateScore(StudentManager sm, CourseManager cm) {
        System.out.print("Input student ID: ");
        String studentId = sc.nextLine().trim().toUpperCase();
        Student student = sm.searchById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Input course ID: ");
        String courseId = sc.nextLine().trim().toUpperCase();

        Enrollment target = null;
        for (Enrollment e : student.getEnrollments()) {
            if (e.getCourse().getCourseId().equals(courseId)) {
                target = e;
                break;
            }
        }

        if (target == null) {
            System.out.println("Enrollment not found.");
            return;
        }

        String column;
        if (!target.getCourse().getGradingSchema().isEmpty()) {
            System.out.print("Input column name to update: ");
            column = sc.nextLine().trim();
        } else {
            column = "score";
        }

        while (true) {
            System.out.print("Input new score (0-10): ");
            try {
                double score = Double.parseDouble(sc.nextLine().trim());
                if (score >= 0 && score <= 10) {
                    target.setScore(column, score);
                    System.out.println("Score updated successfully.");
                    break;
                }
                System.out.println("Invalid score. Must be between 0 and 10.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number format.");
            }
        }
    }

    /**
     * Print all enrollments by iterating through all students
     *
     * @param sm is a StudentManager object contain students and their enrollments
     */
    public void printAll(StudentManager sm) {
        System.out.println("ENROLLMENT LIST\n---------------");
        boolean hasEnrollment = false;
        for (Student student : sm) {
            for (Enrollment e : student.getEnrollments()) {
                hasEnrollment = true;
                System.out.println("Student: " + student.getId()
                        + " | Course: " + e.getCourse().getCourseId()
                        + " | Scores: " + e.getStudentScores()
                        + " | Final: " + String.format("%.2f", e.calculateFinalScore()));
            }
        }
        if (!hasEnrollment) {
            System.out.println("Empty");
        }
    }
}
