package studentlistbasic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class student {

    String id;
    String name;
    double Gpa;

    public student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.Gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return Gpa;
    }

    public student() {
    }

    public void nhap(Scanner sc) {
        id = sc.next();
        name = sc.next();
        Gpa = sc.nextDouble();

    }

    public void in() {

        System.out.println(id + " | " + name + " | " + Gpa);

    }

}

public class Studentlistbasic {

    static ArrayList<student> list = new ArrayList<>();

    static void indanhsach() {
        for (student s : list) {
            s.in();
        }
    }

    static void findmaxGpa() {
        if (list.isEmpty()) {
            return;
        }

        student max = list.get(0);

        for (student s : list) {
            if (s.getGpa() > max.getGpa()) {
                max = s;
            }
        }
        max.in();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            student st = new student();
            st.nhap(sc);
            list.add(st);
        }
        
        System.out.println("=== STUDENT LIST ===");
        
        indanhsach();

        System.out.println("\n=== MAX GPA STUDENT ===");

        findmaxGpa();

    }
}
