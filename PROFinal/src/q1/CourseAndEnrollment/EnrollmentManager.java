package q1.CourseAndEnrollment;

import q1.Student.Student;
import q1.Student.StudentManager;
import java.util.Scanner;
import java.util.Vector;

// Quản lý danh sách đăng ký khóa học
public class EnrollmentManager extends Vector<Enrollment> {

    // Dùng để nhập dữ liệu từ bàn phím
    private final Scanner sc = new Scanner(System.in);

    // Thêm một đăng ký khóa học mới cho sinh viên
    public void addEnrollment(StudentManager sm, CourseManager cm) {

        // Tìm sinh viên theo ID
        System.out.print("Input student ID: ");
        String studentId = sc.nextLine().trim().toUpperCase();
        Student student = sm.searchById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        // Tìm khóa học theo ID
        System.out.print("Input course ID: ");
        String courseId = sc.nextLine().trim().toUpperCase();
        Course course = cm.searchCourse(courseId);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        // Kiểm tra sinh viên đã đăng ký khóa học này chưa
        for (Enrollment e : student.getEnrollments()) {
            if (e.getCourse().getCourseId().equals(courseId)) {
                System.out.println("Student is already enrolled in this course.");
                return;
            }
        }

        // Tạo đối tượng đăng ký khóa học
        Enrollment enrollment = new Enrollment(course);

        // Nhập điểm theo từng cột trong cấu trúc điểm
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

            // Nhập một điểm chung nếu khóa học không có cấu trúc điểm
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

        // Thêm đăng ký vào sinh viên và danh sách quản lý
        student.addEnrollment(enrollment);
        this.add(enrollment);

        // Hiển thị kết quả đăng ký
        System.out.println("Enrolled: " + student.getName() + " -> " + course.getCourseName()
                + " | Final: " + String.format("%.2f", enrollment.calculateFinalScore()));
    }

    // Cập nhật điểm của sinh viên trong một khóa học
    public void updateScore(StudentManager sm, CourseManager cm) {

        // Tìm sinh viên theo ID
        System.out.print("Input student ID: ");
        String studentId = sc.nextLine().trim().toUpperCase();
        Student student = sm.searchById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        // Nhập ID khóa học cần cập nhật điểm
        System.out.print("Input course ID: ");
        String courseId = sc.nextLine().trim().toUpperCase();

        // Tìm đăng ký khóa học của sinh viên
        Enrollment target = null;
        for (Enrollment e : student.getEnrollments()) {
            if (e.getCourse().getCourseId().equals(courseId)) {
                target = e;
                break;
            }
        }

        // Kiểm tra đăng ký có tồn tại không
        if (target == null) {
            System.out.println("Enrollment not found.");
            return;
        }

        // Chọn cột điểm cần cập nhật
        String column;
        if (!target.getCourse().getGradingSchema().isEmpty()) {
            System.out.print("Input column name to update: ");
            column = sc.nextLine().trim();
        } else {
            column = "score";
        }

        // Nhập và cập nhật điểm mới
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

    // Hiển thị toàn bộ danh sách đăng ký khóa học
    public void printAll() {
        System.out.println("ENROLLMENT LIST\n---------------");

        // Kiểm tra danh sách rỗng
        if (this.isEmpty()) {
            System.out.println("Empty");
        } else {

            // Duyệt và hiển thị từng đăng ký
            for (Enrollment e : this) {
                System.out.println("Course: " + e.getCourse().getCourseId()
                        + " | Scores: " + e.getStudentScores()
                        + " | Final: " + String.format("%.2f", e.calculateFinalScore()));
            }
        }
    }
}