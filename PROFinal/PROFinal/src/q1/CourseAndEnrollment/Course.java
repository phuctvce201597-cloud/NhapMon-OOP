package q1.CourseAndEnrollment;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Course {

    private String courseId;
    private String courseName;
    private int credits;
    private Map<String, Double> gradingSchema;

    /**
     *
     */
    public Course() {
        this.gradingSchema = new HashMap<>();
    }

    /**
     *
     * @param courseId
     * @param courseName
     * @param credits
     */
    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.gradingSchema = new HashMap<>();
    }

    /**
     *
     * @return
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     *
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     *
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     *
     * @return
     */
    public int getCredits() {
        return credits;
    }

    /**
     *
     * @param credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     *
     * @return
     */
    public Map<String, Double> getGradingSchema() {
        return gradingSchema;
    }

    /**
     *
     * @param gradingSchema
     */
    public void setGradingSchema(Map<String, Double> gradingSchema) {
        this.gradingSchema = gradingSchema;
    }

    /**
     *
     * @param name
     * @param weight
     */
    public void addGradeColumn(String name, Double weight) {
        this.gradingSchema.put(name, weight);
    }

    /**
     *
     * @return
     */
    public String entry() {
        return String.format("(%s,%s) is added", this.courseId, this.courseName);
    }

    /**
     *
     * @return
     */
    public String print() {
        return String.format("(%s,%s,%d)", this.courseId, this.courseName, this.credits);
    }
}
