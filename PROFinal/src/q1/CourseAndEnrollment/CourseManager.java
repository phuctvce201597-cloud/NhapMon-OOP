package q1.CourseAndEnrollment;

import java.util.Scanner;
import java.util.Vector;

public class CourseManager extends Vector<Course> {

    private final Scanner sc = new Scanner(System.in);

    public void addCourse() {
        String courseId;
        while (true) {
            System.out.print("Input course ID: ");
            courseId = sc.nextLine().trim().toUpperCase();
            if (courseId.matches("^[A-Z]{3}\\d{3}$")) {
                boolean exists = false;
                for (Course c : this) {
                    if (c.getCourseId().equals(courseId)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) break;
                else System.out.println("Course ID already exists.");
            } else {
                System.out.println("Invalid ID format. Must be 3 uppercase letters followed by 3 digits (e.g., PRO192).");
            }
        }

        System.out.print("Input course name: ");
        String courseName = sc.nextLine().trim();

        int credits;
        while (true) {
            System.out.print("Input credits (1-5): ");
            try {
                credits = Integer.parseInt(sc.nextLine().trim());
                if (credits >= 1 && credits <= 5) break;
                System.out.println("Invalid credits. Must be between 1 and 5.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            }
        }

        Course course = new Course(courseId, courseName, credits);
        this.add(course);
        System.out.println(course.entry());
    }

    public void updateCourse() {
        System.out.print("Input course ID to update: ");
        String courseId = sc.nextLine().trim().toUpperCase();
        Course course = searchCourse(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Input new course name: ");
        String name = sc.nextLine().trim();
        if (!name.isEmpty()) {
            course.setCourseName(name);
        }

        System.out.print("Input new credits (1-5): ");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) break;
            try {
                int credits = Integer.parseInt(input);
                if (credits >= 1 && credits <= 5) {
                    course.setCredits(credits);
                    break;
                }
                System.out.println("Invalid credits. Must be between 1 and 5.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            }
        }
        System.out.println("Course updated successfully.");
    }

    public void deleteCourse() {
        System.out.print("Input course ID to delete: ");
        String courseId = sc.nextLine().trim().toUpperCase();
        Course course = searchCourse(courseId);
        if (course != null) {
            this.remove(course);
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public Course searchCourse(String courseId) {
        for (Course c : this) {
            if (c.getCourseId().equalsIgnoreCase(courseId)) {
                return c;
            }
        }
        return null;
    }

    public void printAll() {
        System.out.println("COURSE LIST\n---------------");
        if (this.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Course c : this) {
                System.out.println(c.print());
            }
        }
    }
}
