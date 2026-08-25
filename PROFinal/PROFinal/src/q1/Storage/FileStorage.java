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

/**
 *
 * @author ADMIN
 */
public class FileStorage {

    // Declare text files name
    private static final String STUDENT_FILE = "students.txt";
    private static final String COURSE_FILE = "courses.txt";
    private static final String ENROLLMENT_FILE = "enrollments.txt";

    /**
     * Save students to text file
     * 
     * @param sm is a StudentManager object contain students
     */
    public static void saveStudents(StudentManager sm) {
        // Create a StringBuilder to store student information
        StringBuilder sb = new StringBuilder();
        // Loop through all the students in the StudentManager
        for (Student student : sm) {
            // Check if the student is a CEStudent
            if (student instanceof CEStudent) {
                // Cast the student to a CEStudent
                CEStudent ce = (CEStudent) student;
                // Add the information of CEStudent to the StringBuilder by using append method
                sb.append("CE;").append(ce.getId()).append(";").append(ce.getName()).append(";")
                        .append(ce.getAge()).append(";").append(ce.getEmail()).append(";").append(ce.getPhone())
                        .append(";")
                        .append(ce.getStatus()).append(";").append(ce.getLabScore()).append("\n");
            } else if (student instanceof CSStudent) {
                // Cast the student to a CSStudent
                CSStudent cs = (CSStudent) student;
                // Add the information of CSStudent to the StringBuilder by using append method
                sb.append("CS;").append(cs.getId()).append(";").append(cs.getName()).append(";")
                        .append(cs.getAge()).append(";").append(cs.getEmail()).append(";").append(cs.getPhone())
                        .append(";")
                        .append(cs.getStatus()).append(";").append(cs.getCampaignScore()).append("\n");
            }
        }
        try {
            // Use XorEncryption to write the student information to the text file with xor
            // encryption
            XorEncryption.writeEncrypted(STUDENT_FILE, sb.toString());
            // Print the message to the console
            System.out.println("Students saved to [" + STUDENT_FILE + "] (XOR encrypted).");
        } catch (IOException e) { // Catch the IOException if there is an error
            // print the error message to the console
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    /**
     * Load students from text file
     *
     * @param sm is a StudentManager object contain students
     */
    public static void loadStudents(StudentManager sm) {
        // Use try-catch block to handle the IOException
        try {
            // Read the student information from the text file with xor decryption
            String data = XorEncryption.readDecrypted(STUDENT_FILE);
            // Clear the StudentManager
            sm.clear();
            // Loop through all the lines in the student information
            for (String line : data.split("\n")) {
                // Trim whitespace from the line
                line = line.trim();
                // If the line is empty, continue
                if (line.isEmpty())
                    continue;
                // Split the line into tokens
                String[] tokens = line.split(";");
                // If the number of tokens is less than 8 mean that line does not have enough
                // student's information, skip this line.
                if (tokens.length < 8)
                    continue;
                String type = tokens[0];
                String id = tokens[1];
                String name = tokens[2];
                int age = Integer.parseInt(tokens[3]);
                String email = tokens[4];
                String phone = tokens[5];
                // Declare student stautus
                StudentStatus status;
                try {
                    // Try to convert the string to StudentStatus
                    // Use valueOf method to convert the string to StudentStatus enum, use
                    // uppercase method because the valueOf method is case sensitive
                    status = StudentStatus.valueOf(tokens[6].toUpperCase());
                } catch (IllegalArgumentException e) { // Catch the IllegalArgumentException if there is an
                                                       // error enum argument exception
                    // Set the status to STUDYING as the default value
                    status = StudentStatus.STUDYING;
                }
                Student student = null;
                // Check if the student is a CEStudent
                if (type.equalsIgnoreCase("CE")) {
                    double labScore = Double.parseDouble(tokens[7]);
                    // Create a new CEStudent
                    student = new CEStudent(id, name, age, email, phone, status, labScore);
                } else if (type.equalsIgnoreCase("CS")) {
                    double campaignScore = Double.parseDouble(tokens[7]);
                    // Create a new CSStudent
                    student = new CSStudent(id, name, age, email, phone, status, campaignScore);
                }
                // Add the student to the StudentManager
                if (student != null) {
                    sm.add(student);
                }
            }
            // Print the message to the console
            System.out.println("Students loaded from [" + STUDENT_FILE + "] (" + sm.size() + " records).");
        } catch (IOException e) { // Catch the IOException if there is an error
            // Print the message to the console
            System.out.println("No student file found, starting fresh.");
        }
    }

    /**
     * Save the Courses to the text file with xor encryption
     * 
     * @param cm is a CourseManager object contain courses
     */
    public static void saveCourses(CourseManager cm) {
        // Create a StringBuilder to store course information
        StringBuilder sb = new StringBuilder();
        // Loop through all the courses in the CourseManager
        for (Course c : cm) {
            // Add the information of Course to the StringBuilder by using append method
            sb.append(c.getCourseId()).append(";").append(c.getCourseName()).append(";").append(c.getCredits())
                    .append("\n");
        }
        try {
            // Use XorEncryption to write the course information to the text file with xor
            // encryption
            XorEncryption.writeEncrypted(COURSE_FILE, sb.toString());
            // Print the message to the console
            System.out.println("Courses saved to [" + COURSE_FILE + "] (XOR encrypted).");
        } catch (IOException e) { // Catch the IOException if there is an error
            // Print the error message to the console
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    /**
     * Load courses from text file
     * 
     * @param cm is a CourseManager object contain courses
     */
    public static void loadCourses(CourseManager cm) {
        try {
            // Read the course information from the text file with xor decryption
            String data = XorEncryption.readDecrypted(COURSE_FILE);
            // Clear the CourseManager
            cm.clear();
            // Loop through all the lines in the course information
            for (String line : data.split("\n")) {
                // Trim whitespace from the line
                line = line.trim();
                // If the line is empty, continue
                if (line.isEmpty())
                    continue;
                // Split the line into tokens
                String[] tokens = line.split(";");
                // If the number of tokens is less than 3 mean that line does not have enough
                // course's information, skip this line.
                if (tokens.length < 3)
                    continue;
                // Get the course information from the tokens
                String courseId = tokens[0];
                String courseName = tokens[1];
                int credits = Integer.parseInt(tokens[2]);
                // Add the course to the CourseManager
                cm.add(new Course(courseId, courseName, credits));
            }
            // Print the message to the console
            System.out.println("Courses loaded from [" + COURSE_FILE + "] (" + cm.size() + " records).");
        } catch (IOException e) { // Catch the IOException if there is an error
            // Print the message to the console
            System.out.println("No course file found, starting fresh.");
        }
    }

    /**
     * Save the enrollments from StudentManager to a text file
     * 
     * @param sm is a StudentManager object contain enrollments
     */
    public static void saveEnrollments(StudentManager sm) {
        // Create a StringBuilder to store enrollment information
        StringBuilder sb = new StringBuilder();
        // Loop through all the students in the StudentManager
        for (Student student : sm) {
            // Loop through all the enrollments in the StudentManager
            for (Enrollment e : student.getEnrollments()) {
                // Create a StringBuilder to store score information
                StringBuilder scores = new StringBuilder();
                // Loop through all the scores in the StudentManager
                e.getStudentScores().forEach((col, val) -> scores.append(col).append(":").append(val).append(","));
                // Remove the trailing comma if there is any
                String scoresStr = scores.length() > 0 ? scores.substring(0, scores.length() - 1) : "";
                // Append the enrollment information to the StringBuilder
                sb.append(student.getId()).append(";").append(e.getCourse().getCourseId()).append(";").append(scoresStr)
                        .append("\n");
            }
        }
        try { // Use XorEncryption to write the enrollment information to the text file with
              // xor encryption
            XorEncryption.writeEncrypted(ENROLLMENT_FILE, sb.toString());
            // Print the message to the console
            System.out.println("Enrollments saved to [" + ENROLLMENT_FILE + "] (XOR encrypted).");
        } catch (IOException e) { // Catch the IOException if there is an error
            // Print the error message to the console
            System.out.println("Error saving enrollments: " + e.getMessage());
        }
    }

    /**
     * Load enrollments from StudentManager to a text file
     * 
     * @param sm is a StudentManager object contain enrollments
     * @param cm is a CourseManager object contain courses
     */
    public static void loadEnrollments(StudentManager sm, CourseManager cm) {
        try { // Use XorEncryption to read the enrollment information from the text file with
              // xor decryption
            String data = XorEncryption.readDecrypted(ENROLLMENT_FILE);
            // Loop through all the lines in the enrollment information
            for (String line : data.split("\n")) {
                // Trim whitespace from the line
                line = line.trim();
                // Check if the line is empty, if so, continue
                if (line.isEmpty())
                    continue;
                // Split the line into tokens
                String[] tokens = line.split(";");
                // If the number of tokens is less than 2 mean that line does not have enough
                // enrollment's information, skip this line.
                if (tokens.length < 2)
                    continue;
                String studentId = tokens[0];
                String courseId = tokens[1];
                Student student = sm.searchById(studentId);
                Course course = cm.searchCourse(courseId);
                // Check if the student or course is null, if so, continue
                if (student == null || course == null)
                    continue;
                // Create a new enrollment with the course
                Enrollment enrollment = new Enrollment(course);
                // Check if the tokens length is greater than or equal to 3 and the third
                // token is not empty
                if (tokens.length >= 3 && !tokens[2].isEmpty()) {
                    // Loop through all the pairs in the third token
                    for (String pair : tokens[2].split(",")) {
                        // Split the pair into key-value
                        String[] kv = pair.split(":");
                        // Check if the pair has 2 tokens
                        if (kv.length == 2) {
                            // Set the score to the enrollment
                            enrollment.setScore(kv[0], Double.parseDouble(kv[1]));
                        }
                    }
                }
                // Add the enrollment to the student
                student.addEnrollment(enrollment);
            }
            // Print the message to the console
            System.out.println("Enrollments loaded from [" + ENROLLMENT_FILE + "].");
        } catch (IOException e) {
            // Print the message to the console
            System.out.println("No enrollment file found, starting fresh.");
        }
    }
}
