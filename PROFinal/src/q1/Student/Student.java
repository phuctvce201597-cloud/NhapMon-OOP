package q1.Student;

import q1.Interface.Reportable;
import q1.CourseAndEnrollment.Enrollment;
import java.util.ArrayList;
import java.util.List;

public abstract class Student implements Reportable {

    private String id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private StudentStatus status;
    private List<Enrollment> enrollments;

    public Student() {
        this.enrollments = new ArrayList<>();
        this.status = StudentStatus.STUDYING;
    }

    public Student(String id, String name, int age, String email, String phone, StudentStatus status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.enrollments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void addEnrollment(Enrollment e) {
        this.enrollments.add(e);
    }

    @Override
    public abstract String print();

    @Override
    public abstract String entry();

    @Override
    public abstract double gpa();

    public static enum StudentStatus {
        STUDYING,
        GRADUATED,
        SUSPENDED,
        DROPPED
    }
}
