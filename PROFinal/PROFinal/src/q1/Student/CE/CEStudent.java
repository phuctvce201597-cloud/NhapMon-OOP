package q1.Student.CE;

import q1.Student.Student;
import q1.CourseAndEnrollment.Enrollment;

/**
 *
 * @author ADMIN
 */
public class CEStudent extends Student {

    private double labScore;

    /**
     *
     */
    public CEStudent() {
        super();
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
    public CEStudent(String id, String name, int age, String email, String phone, StudentStatus status) {
        super(id, name, age, email, phone, status);
    }

    /**
     *
     * @param id
     * @param name
     * @param age
     * @param email
     * @param phone
     * @param status
     * @param labScore
     */
    public CEStudent(String id, String name, int age, String email, String phone, StudentStatus status,
            double labScore) {
        super(id, name, age, email, phone, status);
        this.labScore = labScore;
    }

    /**
     *
     * @return
     */
    public double getLabScore() {
        return labScore;
    }

    /**
     *
     * @param labScore
     */
    public void setLabScore(double labScore) {
        this.labScore = labScore;
    }

    /**
     *
     * @return
     */
    @Override
    public double gpa() {
        double total = 0;
        for (Enrollment e : getEnrollments()) {
            total += e.calculateFinalScore();
        }
        int count = getEnrollments().size();
        double enrollmentAvg = count == 0 ? 0 : total / count;
        return enrollmentAvg * 0.70 + labScore * 0.30;
    }

    /**
     *
     * @return
     */
    @Override
    public String entry() {
        return "[CE] ID: " + getId() + " | Name: " + getName() + " | Age: " + getAge()
                + " | Email: " + getEmail() + " | Phone: " + getPhone()
                + " | Status: " + getStatus() + " | Lab: " + labScore;
    }

    /**
     *
     * @return
     */
    @Override
    public String print() {
        return "[CE] ID: " + getId() + " | Name: " + getName() + " | Age: " + getAge()
                + " | Status: " + getStatus() + " | GPA: " + String.format("%.2f", gpa());
    }
}
