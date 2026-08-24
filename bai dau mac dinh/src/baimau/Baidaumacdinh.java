package baimau;

import java.util.ArrayList;
import java.util.Scanner;

class Student {

    String id;
    String name;
    double gpa;

    // Constructor
    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Nhập 1 student
    public void input(Scanner sc) {
        id = sc.next();
        name = sc.next();
        gpa = sc.nextDouble();
    }

    // Xuất 1 student
    public void output() {
        System.out.println(id + " | " + name + " | " + gpa);
    }
}

public class Baidaumacdinh {

    static ArrayList<Student> list = new ArrayList<>();

    // Hiển thị danh sách
    static void displayStudents() {
        for (Student s : list) {
            s.output();
        }
    }

    // Tìm theo ID
    static void findStudentById(String findId) {
        for (Student s : list) {
            if (s.id.equalsIgnoreCase(findId)) {
                s.output();
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Nhập số lượng
        int n = sc.nextInt();

        // Nhập list student
        for (int i = 0; i < n; i++) {
            Student stu = new Student("", "", 0);
            stu.input(sc);
            list.add(stu);
        }

        // Hiển thị list
        displayStudents();

        // Nhập ID cần tìm
        String findId = sc.next();

        // Search
        findStudentById(findId);
    }
}