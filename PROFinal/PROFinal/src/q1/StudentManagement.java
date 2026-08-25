package q1;

import q1.Student.StudentManager;
import q1.Student.StudentStatistics;
import q1.CourseAndEnrollment.CourseManager;
import q1.CourseAndEnrollment.EnrollmentManager;
import q1.Storage.FileStorage;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class StudentManagement {

    private static Scanner sc = new Scanner(System.in);
    private static StudentManager sm = new StudentManager();
    private static CourseManager cm = new CourseManager();
    private static EnrollmentManager em = new EnrollmentManager();

    // ─────────────────────── MAIN ───────────────────────

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        FileStorage.loadStudents(sm);
        FileStorage.loadCourses(cm);
        FileStorage.loadEnrollments(sm, cm);

        int option;
        do {
            printMainMenu();
            option = readInt();
            switch (option) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 3:
                    enrollmentMenu();
                    break;
                case 4:
                    statisticsMenu();
                    break;
                case 0:
                    saveAll();
                    System.out.println("Data saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0-4.");
            }
        } while (option != 0);

        sc.close();
    }

    // ─────────────────────── MAIN MENU ───────────────────────

    private static void printMainMenu() {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("  1. Student");
        System.out.println("  2. Course");
        System.out.println("  3. Enrollment");
        System.out.println("  4. Statistics");
        System.out.println("  0. Quit");
        System.out.println("==========================================");
        System.out.print("Choose section: ");
    }

    // ─────────────────────── STUDENT MENU ───────────────────────

    private static void studentMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("------ STUDENT ------");
            System.out.println("  1. Add new student");
            System.out.println("  2. Update student");
            System.out.println("  3. Delete student");
            System.out.println("  4. Print all students");
            System.out.println("  5. Sort by name (A-Z)");
            System.out.println("  6. Sort by GPA (desc)");
            System.out.println("  0. Back");
            System.out.print("Choose: ");
            option = readInt();
            switch (option) {
                case 1:
                    sm.addStudent();
                    break;
                case 2:
                    sm.updateStudent();
                    break;
                case 3:
                    sm.deleteStudent();
                    break;
                case 4:
                    sm.printAll();
                    break;
                case 5:
                    sm.sortByNameAsc();
                    sm.printAll();
                    break;
                case 6:
                    sm.sortByGpaDesc();
                    sm.printAll();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    // ─────────────────────── COURSE MENU ───────────────────────

    private static void courseMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("------ COURSE ------");
            System.out.println("  1. Add course");
            System.out.println("  2. Update course");
            System.out.println("  3. Delete course");
            System.out.println("  4. Print all courses");
            System.out.println("  0. Back");
            System.out.print("Choose: ");
            option = readInt();
            switch (option) {
                case 1:
                    cm.addCourse();
                    break;
                case 2:
                    cm.updateCourse();
                    break;
                case 3:
                    cm.deleteCourse();
                    break;
                case 4:
                    cm.printAll();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    // ─────────────────────── ENROLLMENT MENU ───────────────────────

    private static void enrollmentMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("------ ENROLLMENT ------");
            System.out.println("  1. Enroll student in course");
            System.out.println("  2. Update enrollment score");
            System.out.println("  3. Print all enrollments");
            System.out.println("  4. Print student transcript");
            System.out.println("  0. Back");
            System.out.print("Choose: ");
            option = readInt();
            switch (option) {
                case 1:
                    em.addEnrollment(sm, cm);
                    break;
                case 2:
                    em.updateScore(sm, cm);
                    break;
                case 3:
                    em.printAll(sm);
                    break;
                case 4:
                    printTranscript();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    // ─────────────────────── STATISTICS MENU ───────────────────────

    private static void statisticsMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("------ STATISTICS ------");
            System.out.println("  1. Count students by major");
            System.out.println("  2. Find top GPA student");
            System.out.println("  3. Count students per course");
            System.out.println("  4. Average GPA by major");
            System.out.println("  0. Back");
            System.out.print("Choose: ");
            option = readInt();
            switch (option) {
                case 1:
                    StudentStatistics.countByMajor(sm);
                    break;
                case 2:
                    StudentStatistics.findTopGpa(sm);
                    break;
                case 3:
                    StudentStatistics.countStudentsPerCourse(sm);
                    break;
                case 4:
                    StudentStatistics.averageGpaByMajor(sm);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    // ─────────────────────── HELPERS ───────────────────────

    private static void printTranscript() {
        System.out.print("Input student ID: ");
        String sid = sc.nextLine().trim();
        StudentStatistics.printTranscript(sm, sid);
    }

    private static void saveAll() {
        FileStorage.saveStudents(sm);
        FileStorage.saveCourses(cm);
        FileStorage.saveEnrollments(sm);
    }

    /** read int from input, return -1 if invalid */
    private static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}