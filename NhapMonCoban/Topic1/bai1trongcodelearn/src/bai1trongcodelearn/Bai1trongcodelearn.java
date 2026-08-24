package bai1trongcodelearn;

import java.util.Scanner;
import java.util.Arrays;

public class Bai1trongcodelearn {

    static class sinhvien {

        String name;
        int age;

        public void nhap() {
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();
            age = sc.nextInt();
        }

        public void in() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }

    public static void main(String[] args) {

        sinhvien sinhvien1 = new sinhvien();

        sinhvien1.nhap();
        sinhvien1.in();

    }
}
