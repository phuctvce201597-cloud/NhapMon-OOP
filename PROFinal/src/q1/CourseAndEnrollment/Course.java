package q1.CourseAndEnrollment;

import java.util.HashMap;
import java.util.Map;

public class Course {

    private String courseId;
    private String courseName;
    private int credits;
    private Map<String, Double> gradingSchema;

    public Course() {
        this.gradingSchema = new HashMap<>();
    }

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.gradingSchema = new HashMap<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Map<String, Double> getGradingSchema() {
        return gradingSchema;
    }

    public void setGradingSchema(Map<String, Double> gradingSchema) {
        this.gradingSchema = gradingSchema;
    }

    public void addGradeColumn(String name, Double weight) {
        this.gradingSchema.put(name, weight);
    }

    public String entry() {
        return String.format("(%s,%s) is added", this.courseId, this.courseName);
    }

    public String print() {
        return String.format("(%s,%s,%d)", this.courseId, this.courseName, this.credits);
    }
}
