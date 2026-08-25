package q1.Student;

import q1.Interface.Reportable;
import q1.CourseAndEnrollment.Enrollment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public abstract class Student implements Reportable {

    private String id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private StudentStatus status;
    private List<Enrollment> enrollments;

    /**
     *
     */
    public Student() {
        this.enrollments = new ArrayList<>();
        this.status = StudentStatus.STUDYING;
    }

    /**
     *
     * @param id
     * @param name
     * @param age
     * @param email
     * @param phone
     * @param status
     */
    public Student(String id, String name, int age, String email, String phone, StudentStatus status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.enrollments = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public StudentStatus getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    /**
     *
     * @param enrollments
     */
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    /**
     *
     * @param e
     */
    public void addEnrollment(Enrollment e) {
        this.enrollments.add(e);
    }

    /**
     *
     * @return
     */
    @Override
    public abstract String print();

    /**
     *
     * @return
     */
    @Override
    public abstract String entry();

    /**
     *
     * @return
     */
    @Override
    public abstract double gpa();

    /**
     *
     */
    public static enum StudentStatus {

        /**
         *
         */
        STUDYING,

        /**
         *
         */
        GRADUATED,

        /**
         *
         */
        SUSPENDED,

        /**
         *
         */
        DROPPED
    }
}
