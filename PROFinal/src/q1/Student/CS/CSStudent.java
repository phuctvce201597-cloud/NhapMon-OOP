package q1.Student.CS;

import q1.Student.Student;
import q1.CourseAndEnrollment.Enrollment;

public class CSStudent extends Student {

    private double campaignScore;

    public CSStudent() {
        super();
    }

    public CSStudent(String id, String name, int age, String email, String phone, StudentStatus status) {
        super(id, name, age, email, phone, status);
    }

    public CSStudent(String id, String name, int age, String email, String phone, StudentStatus status,
            double campaignScore) {
        super(id, name, age, email, phone, status);
        this.campaignScore = campaignScore;
    }

    public double getCampaignScore() {
        return campaignScore;
    }

    public void setCampaignScore(double campaignScore) {
        this.campaignScore = campaignScore;
    }

    @Override
    public double gpa() {
        double total = 0;
        for (Enrollment e : getEnrollments()) {
            total += e.calculateFinalScore();
        }
        int count = getEnrollments().size();
        double enrollmentAvg = count == 0 ? 0 : total / count;
        return enrollmentAvg * 0.70 + campaignScore * 0.30;
    }

    @Override
    public String entry() {
        return "[CS] ID: " + getId() + " | Name: " + getName() + " | Age: " + getAge()
                + " | Email: " + getEmail() + " | Phone: " + getPhone()
                + " | Status: " + getStatus()
                + " | Campaign: " + campaignScore;
    }

    @Override
    public String print() {
        return "[CS] ID: " + getId() + " | Name: " + getName() + " | Age: " + getAge()
                + " | Status: " + getStatus() + " | GPA: " + String.format("%.2f", gpa());
    }
}