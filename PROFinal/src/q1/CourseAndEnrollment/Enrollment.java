package q1.CourseAndEnrollment;

import java.util.HashMap;
import java.util.Map;

public class Enrollment {

    private Course course;
    private Map<String, Double> studentScores;

    public Enrollment() {
        this.studentScores = new HashMap<>();
    }

    public Enrollment(Course course) {
        this.course = course;
        this.studentScores = new HashMap<>();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Map<String, Double> getStudentScores() {
        return studentScores;
    }

    public void setStudentScores(Map<String, Double> studentScores) {
        this.studentScores = studentScores;
    }

    public void setScore(String column, double score) {
        this.studentScores.put(column, score);
    }

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
