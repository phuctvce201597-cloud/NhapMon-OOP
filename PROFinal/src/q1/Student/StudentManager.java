package q1.Student;

import q1.Student.CE.CEStudent;
import q1.Student.CS.CSStudent;
import q1.Student.Student.StudentStatus;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class StudentManager extends Vector<Student> {

    private final Scanner sc = new Scanner(System.in);

    public void addStudent() {
        String type;
        while (true) {
            System.out.print("Input student type (CE/CS): ");
            type = sc.nextLine().trim();
            if (type.equalsIgnoreCase("CE") || type.equalsIgnoreCase("CS")) {
                break;
            }
            System.out.println("Invalid type. Please enter CE or CS.");
        }

        String id;
        while (true) {
            System.out.print("Input student ID: ");
            id = sc.nextLine().trim();
            if (id.matches("(?i)^[A-Z]{2}\\d{6}$")) {
                id = id.toUpperCase();
                boolean exists = false;
                for (Student s : this) {
                    if (s.getId().equalsIgnoreCase(id)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists)
                    break;
                else
                    System.out.println("ID already exists.");
            } else {
                System.out.println("Invalid ID format. Must be 2 letters followed by 6 digits (e.g., CE180399).");
            }
        }

        String name;
        while (true) {
            System.out.print("Input full name: ");
            name = sc.nextLine().trim();
            if (name.matches("^[a-zA-Z\\s]+$")) {
                break;
            }
            System.out.println("Invalid name format. Only letters and spaces are allowed.");
        }

        int age;
        while (true) {
            System.out.print("Input age: ");
            try {
                age = Integer.parseInt(sc.nextLine().trim());
                if (age >= 15 && age <= 100)
                    break;
                System.out.println("Invalid age. Must be between 15 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            }
        }

        System.out.print("Input email: ");
        String email = sc.nextLine().trim();

        System.out.print("Input phone: ");
        String phone = sc.nextLine().trim();

        StudentStatus status = inputStudentStatus();

        Student student = null;

        if (type.equalsIgnoreCase("CE")) {
            double labScore;
            while (true) {
                System.out.print("Input lab score: ");
                try {
                    labScore = Double.parseDouble(sc.nextLine().trim());
                    if (labScore >= 0 && labScore <= 10)
                        break;
                    System.out.println("Invalid score. Must be between 0 and 10.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
            }
            student = new CEStudent(id, name, age, email, phone, status, labScore);
        } else if (type.equalsIgnoreCase("CS")) {
            double campaignScore;
            while (true) {
                System.out.print("Input campaign score: ");
                try {
                    campaignScore = Double.parseDouble(sc.nextLine().trim());
                    if (campaignScore >= 0 && campaignScore <= 10)
                        break;
                    System.out.println("Invalid score. Must be between 0 and 10.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
            }
            student = new CSStudent(id, name, age, email, phone, status, campaignScore);
        }

        if (student != null) {
            this.add(student);
            System.out.println("Student added successfully. Entry: " + student.entry());
        }
    }

    public void updateStudent() {
        System.out.print("Input student ID to update: ");
        String id = sc.nextLine().trim();
        Student student = searchById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Input new full name: ");
        String name;
        while (true) {
            name = sc.nextLine().trim();
            if (name.matches("^[a-zA-Z\\s]+$")) {
                student.setName(name);
                break;
            }
            System.out.println("Invalid name format. Only letters and spaces are allowed.");
        }

        System.out.print("Input new age: ");
        while (true) {
            try {
                int age = Integer.parseInt(sc.nextLine().trim());
                if (age >= 15 && age <= 100) {
                    student.setAge(age);
                    break;
                }
                System.out.println("Invalid age. Must be between 15 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            }
        }

        System.out.print("Input new email: ");
        student.setEmail(sc.nextLine().trim());

        System.out.print("Input new phone: ");
        student.setPhone(sc.nextLine().trim());

        student.setStatus(inputStudentStatus());

        if (student instanceof CEStudent) {
            CEStudent ce = (CEStudent) student;
            System.out.print("Input new lab score: ");
            while (true) {
                try {
                    double score = Double.parseDouble(sc.nextLine().trim());
                    if (score >= 0 && score <= 10) {
                        ce.setLabScore(score);
                        break;
                    }
                    System.out.println("Invalid score. Must be between 0 and 10.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
            }
        } else if (student instanceof CSStudent) {
            CSStudent cs = (CSStudent) student;
            System.out.print("Input new campaign score: ");
            while (true) {
                try {
                    double score = Double.parseDouble(sc.nextLine().trim());
                    if (score >= 0 && score <= 10) {
                        cs.setCampaignScore(score);
                        break;
                    }
                    System.out.println("Invalid score. Must be between 0 and 10.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
            }
        }
        System.out.println("Student updated successfully. Entry: " + student.entry());
    }

    public void deleteStudent() {
        System.out.print("Input student ID to delete: ");
        String id = sc.nextLine().trim();
        Student student = searchById(id);
        if (student != null) {
            this.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchById(String id) {
        for (Student s : this) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public void sortByNameAsc() {
        Collections.sort(this, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });
        System.out.println("Sorted by name ascending.");
    }

    public void sortByGpaDesc() {
        Collections.sort(this, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.gpa(), s1.gpa());
            }
        });
        System.out.println("Sorted by GPA descending.");
    }

    public void printAll() {
        System.out.print("STUDENT LIST\n---------------\n");
        if (this.isEmpty()) {
            System.out.print("Empty\n");
        } else {
            for (Student x : this) {
                System.out.println(x.print());
            }
        }
    }

    public StudentStatus inputStudentStatus() {
        StudentStatus status;
        while (true) {
            System.out.println("Select status:");
            System.out.println("  1. STUDYING");
            System.out.println("  2. GRADUATED");
            System.out.println("  3. SUSPENDED");
            System.out.println("  4. DROPPED");
            System.out.print("Enter choice (1-4): ");
            String statusChoice = sc.nextLine().trim();
            switch (statusChoice) {
                case "1":
                    status = StudentStatus.STUDYING;
                    break;
                case "2":
                    status = StudentStatus.GRADUATED;
                    break;
                case "3":
                    status = StudentStatus.SUSPENDED;
                    break;
                case "4":
                    status = StudentStatus.DROPPED;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3 or 4.");
                    continue;
            }
            break;
        }
        return status;
    }

}