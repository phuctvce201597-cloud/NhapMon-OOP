package q1.Storage;

import q1.Student.Student;
import q1.Student.Student.StudentStatus;
import q1.Student.CE.CEStudent;
import q1.Student.CS.CSStudent;
import q1.CourseAndEnrollment.Course;
import q1.CourseAndEnrollment.CourseManager;
import q1.CourseAndEnrollment.Enrollment;
import q1.Student.StudentManager;
import java.io.IOException;

public class FileStorage {

    private static final String STUDENT_FILE = "students.txt";
    private static final String COURSE_FILE = "courses.txt";
    private static final String ENROLLMENT_FILE = "enrollments.txt";

    public static void saveStudents(StudentManager sm) {
        StringBuilder sb = new StringBuilder();
        for (Student student : sm) {
            if (student instanceof CEStudent) {
                CEStudent ce = (CEStudent) student;
                sb.append("CE;").append(ce.getId()).append(";").append(ce.getName()).append(";")
                        .append(ce.getAge()).append(";").append(ce.getEmail()).append(";").append(ce.getPhone())
                        .append(";")
                        .append(ce.getStatus()).append(";").append(ce.getLabScore()).append("\n");
            } else if (student instanceof CSStudent) {
                CSStudent cs = (CSStudent) student;
                sb.append("CS;").append(cs.getId()).append(";").append(cs.getName()).append(";")
                        .append(cs.getAge()).append(";").append(cs.getEmail()).append(";").append(cs.getPhone())
                        .append(";")
                        .append(cs.getStatus()).append(";").append(cs.getCampaignScore()).append("\n");
            }
        }
        try {
            XorEncryption.writeEncrypted(STUDENT_FILE, sb.toString());
            System.out.println("Students saved to [" + STUDENT_FILE + "] (XOR encrypted).");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public static void loadStudents(StudentManager sm) {
        try {
            String data = XorEncryption.readDecrypted(STUDENT_FILE);
            sm.clear();
            for (String line : data.split("\n")) {
                line = line.trim();
                if (line.isEmpty())
                    continue;
                String[] tokens = line.split(";");
                if (tokens.length < 8)
                    continue;
                String type = tokens[0];
                String id = tokens[1];
                String name = tokens[2];
                int age = Integer.parseInt(tokens[3]);
                String email = tokens[4];
                String phone = tokens[5];
                StudentStatus status;
                try {
                    status = StudentStatus.valueOf(tokens[6].toUpperCase());
                } catch (IllegalArgumentException e) {
                    status = StudentStatus.STUDYING;
                }
                Student student = null;
                if (type.equalsIgnoreCase("CE")) {
                    double labScore = Double.parseDouble(tokens[7]);
                    student = new CEStudent(id, name, age, email, phone, status, labScore);
                } else if (type.equalsIgnoreCase("CS")) {
                    double campaignScore = Double.parseDouble(tokens[7]);
                    student = new CSStudent(id, name, age, email, phone, status, campaignScore);
                }
                if (student != null) {
                    sm.add(student);
                }
            }
            System.out.println("Students loaded from [" + STUDENT_FILE + "] (" + sm.size() + " records).");
        } catch (IOException e) {
            System.out.println("No student file found, starting fresh.");
        }
    }

    public static void saveCourses(CourseManager cm) {
        StringBuilder sb = new StringBuilder();
        for (Course c : cm) {
            sb.append(c.getCourseId()).append(";").append(c.getCourseName()).append(";").append(c.getCredits())
                    .append("\n");
        }
        try {
            XorEncryption.writeEncrypted(COURSE_FILE, sb.toString());
            System.out.println("Courses saved to [" + COURSE_FILE + "] (XOR encrypted).");
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    public static void loadCourses(CourseManager cm) {
        try {
            String data = XorEncryption.readDecrypted(COURSE_FILE);
            cm.clear();
            for (String line : data.split("\n")) {
                line = line.trim();
                if (line.isEmpty())
                    continue;
                String[] tokens = line.split(";");
                if (tokens.length < 3)
                    continue;
                String courseId = tokens[0];
                String courseName = tokens[1];
                int credits = Integer.parseInt(tokens[2]);
                cm.add(new Course(courseId, courseName, credits));
            }
            System.out.println("Courses loaded from [" + COURSE_FILE + "] (" + cm.size() + " records).");
        } catch (IOException e) {
            System.out.println("No course file found, starting fresh.");
        }
    }

    public static void saveEnrollments(StudentManager sm) {
        StringBuilder sb = new StringBuilder();
        for (Student student : sm) {
            for (Enrollment e : student.getEnrollments()) {
                StringBuilder scores = new StringBuilder();
                e.getStudentScores().forEach((col, val) -> scores.append(col).append(":").append(val).append(","));
                String scoresStr = scores.length() > 0 ? scores.substring(0, scores.length() - 1) : "";
                sb.append(student.getId()).append(";").append(e.getCourse().getCourseId()).append(";").append(scoresStr)
                        .append("\n");
            }
        }
        try {
            XorEncryption.writeEncrypted(ENROLLMENT_FILE, sb.toString());
            System.out.println("Enrollments saved to [" + ENROLLMENT_FILE + "] (XOR encrypted).");
        } catch (IOException e) {
            System.out.println("Error saving enrollments: " + e.getMessage());
        }
    }

    public static void loadEnrollments(StudentManager sm, CourseManager cm) {
        try {
            String data = XorEncryption.readDecrypted(ENROLLMENT_FILE);
            for (String line : data.split("\n")) {
                line = line.trim();
                if (line.isEmpty())
                    continue;
                String[] tokens = line.split(";");
                if (tokens.length < 2)
                    continue;
                String studentId = tokens[0];
                String courseId = tokens[1];
                Student student = sm.searchById(studentId);
                Course course = cm.searchCourse(courseId);
                if (student == null || course == null)
                    continue;
                Enrollment enrollment = new Enrollment(course);
                if (tokens.length >= 3 && !tokens[2].isEmpty()) {
                    for (String pair : tokens[2].split(",")) {
                        String[] kv = pair.split(":");
                        if (kv.length == 2) {
                            enrollment.setScore(kv[0], Double.parseDouble(kv[1]));
                        }
                    }
                }
                student.addEnrollment(enrollment);
            }
            System.out.println("Enrollments loaded from [" + ENROLLMENT_FILE + "].");
        } catch (IOException e) {
            System.out.println("No enrollment file found, starting fresh.");
        }
    }
}
