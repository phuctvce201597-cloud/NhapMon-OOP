package q1.CourseAndEnrollment;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Enrollment {

    private Course course;
    private Map<String, Double> studentScores;

    /**
     *
     */
    public Enrollment() {
        this.studentScores = new HashMap<>();
    }

    /**
     *
     * @param course
     */
    public Enrollment(Course course) {
        this.course = course;
        this.studentScores = new HashMap<>();
    }

    /**
     *
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     *
     * @return
     */
    public Map<String, Double> getStudentScores() {
        return studentScores;
    }

    /**
     *
     * @param studentScores
     */
    public void setStudentScores(Map<String, Double> studentScores) {
        this.studentScores = studentScores;
    }

    /**
     *
     * @param column
     * @param score
     */
    public void setScore(String column, double score) {
        this.studentScores.put(column, score);
    }

    /**
     *
     * @return
     */
    public double calculateFinalScore() {
        Map<String, Double> schema = course.getGradingSchema();
        if (schema.isEmpty()) {
            Double score = studentScores.get("score");
            return score != null ? score : 0;
        }
        double total = 0;
        for (Map.Entry<String, Double> entry : schema.entrySet()) {
            Double score = studentScores.get(entry.getKey());
            if (score != null) {
                total += score * entry.getValue();
            }
        }
        return total;
    }
}
